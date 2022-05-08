package com.web.dacn.service.client.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.dacn.dto.book.BookCategoryDTO;
import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.book.OnlineDTO;
import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.entity.book.Book;
import com.web.dacn.entity.book.Online;
import com.web.dacn.repository.AudioRepository;
import com.web.dacn.repository.BookRepository;
import com.web.dacn.repository.OnlineRepository;
import com.web.dacn.repository.PdfRepository;
import com.web.dacn.service.client.ReadOnlineService;

@Service
public class ReadOnlineServiceImpl implements ReadOnlineService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OnlineRepository onlineRepository;
	
	@Autowired
	private PdfRepository pdfRepository;
	
	@Autowired 
	private AudioRepository audioRepository;
	
	@Override
	public BookDTO loadBook(String slug) throws RuntimeException {
		BookDTO dto = new BookDTO();
		Optional<Book> optional = bookRepository.findOneBySlug(slug);
		Book book = optional.get();
		if(optional.isPresent()) {
			try {
				BeanUtils.copyProperties(optional.get(), dto);
				book.getAuthors().stream().forEach(author -> {
					AuthorDTO authorDTO = new AuthorDTO();
					BeanUtils.copyProperties(author, authorDTO);
					dto.getAuthors().add(authorDTO);
				});
				
				book.getOnlines().stream().forEach(online -> {
					OnlineDTO onlineDTO = new OnlineDTO();
					BeanUtils.copyProperties(online, onlineDTO);
					onlineDTO.setContent(null);
					dto.getOnlines().add(onlineDTO);
					Collections.sort(dto.getOnlines(), new Comparator<OnlineDTO>() {
						@Override
						public int compare(OnlineDTO o1, OnlineDTO o2) {
							return o1.getPriority() - o2.getPriority();
						}
					});
				});
					
				book.getCategories().stream().forEach(category -> {
					BookCategoryDTO categoryDTO = new BookCategoryDTO();
					BeanUtils.copyProperties(category, categoryDTO);
					dto.getCategories().add(categoryDTO);
				});
				
				return dto;
				
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} else {
			return null;
		}
		
	}


	@Override
	public OnlineDTO loadChapter(long bookId, int chapter) {
		List<Online> onlines = onlineRepository.findByBookIdOrderByPriorityAsc(bookId, PageRequest.of(chapter - 1, 1));
		OnlineDTO onlineDTO = new OnlineDTO();
		BeanUtils.copyProperties(onlines.get(0), onlineDTO);
		return onlineDTO;
	}



	@Override
	public boolean existsPdfRead(long bookId) {
		return pdfRepository.existsByBookId(bookId);
	}
	


	@Override
	public boolean existsAudio(long bookId) {
		return audioRepository.existsByBookId(bookId);
	}

	
}
