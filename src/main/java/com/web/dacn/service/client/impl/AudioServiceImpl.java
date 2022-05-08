package com.web.dacn.service.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dacn.dto.book.AudioDTO;
import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.entity.book.Audio;
import com.web.dacn.entity.book.Book;
import com.web.dacn.repository.AudioRepository;
import com.web.dacn.repository.BookRepository;
import com.web.dacn.repository.OnlineRepository;
import com.web.dacn.repository.PdfRepository;
import com.web.dacn.service.client.AudioService;

@Service
public class AudioServiceImpl implements AudioService{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AudioRepository audioRepository;
	
	@Autowired
	private PdfRepository pdfRepository;

	@Autowired
	private OnlineRepository onlineRepository;
	
	@Override
	public BookDTO findBookBySlug(String slug) {
		Optional<Book> optional = bookRepository.findOneBySlug(slug);
		if(optional.isPresent()) {
			BookDTO dto = new BookDTO();
			Book book = optional.get();
			
			dto.setId(book.getId());
			dto.setName(book.getName());
			dto.setSlug(book.getSlug());
			dto.setThumbnail(book.getThumbnail());
			dto.setDescription(book.getDescription());

			if(book.getAuthors()!= null && book.getAuthors().size()>0) {
				book.getAuthors().stream().forEach(author->{
					AuthorDTO authorDTO = new AuthorDTO();
					authorDTO.setId(author.getId());
					authorDTO.setSlug(author.getSlug());
					authorDTO.setFullname(author.getFullname());
					dto.getAuthors().add(authorDTO);
				});
			}
			return dto;
		}
		return null;
	}

	@Override
	public List<AudioDTO> findAudiosByBook(Long bookId) {
		List<Audio> audios = audioRepository.findByBookIdOrderByPriorityAsc (bookId);
		List<AudioDTO> results= new ArrayList<>();
		if(audios!= null && audios.size()>0) {
			audios.stream().forEach(audio->{
				AudioDTO dto = new AudioDTO();
				dto.setId(audio.getId());
				dto.setPriority(audio.getPriority());
				dto.setName(audio.getName());
				dto.setUrl(audio.getUrl());
				results.add(dto);
			});
		}
		return results;
	}
	
	@Override
	public boolean existsPdf(Long bookId) {
		return pdfRepository.existsByBookId(bookId);
	}

	@Override
	public boolean existsEbook(Long bookId) {
		return onlineRepository.existsByBookId(bookId);
	}
}
