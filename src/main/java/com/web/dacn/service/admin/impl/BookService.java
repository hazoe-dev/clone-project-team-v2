package com.web.dacn.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.entity.book.Audio;
import com.web.dacn.entity.book.Book;
import com.web.dacn.entity.book.Online;
import com.web.dacn.entity.book.Pdf;
import com.web.dacn.repository.AudioRepository;
import com.web.dacn.repository.BookRepository;
import com.web.dacn.repository.OnlineRepository;
import com.web.dacn.repository.PdfRepository;
import com.web.dacn.service.admin.IBookService;
import com.web.dacn.utils.Converter;

@Service
public class BookService implements IBookService {
	private static int size = 20;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PdfRepository pdfRepository;
	@Autowired
	private AudioRepository audioRepository;
	@Autowired
	private OnlineRepository onlineRepository;
	@Autowired
	private Converter bookConverter;

	// Get read format of book
	@Override
	public List<String> getReadFromat(long bookId) {
		List<String> readFormat = new ArrayList<String>();
		List<Pdf> pdfs = pdfRepository.findByBookId(bookId);
		if (pdfs.size() > 0) {
			readFormat.add("Đọc PDF");
		}
		List<Online> onlines = onlineRepository.findByBookId(bookId);

		if (onlines.size() > 0) {
			readFormat.add("Đọc online");
		}
		List<Audio> audios = audioRepository.findByBookId(bookId);
		if (audios.size() > 0) {
			readFormat.add("Nghe audio");
		}
		return readFormat;

	}

	
	public Pageable getBookEntitesByPage(int page) {
		Pageable pageable = PageRequest.of(page, size);
		return null;
	}

	@Override
	// Get books + paging
	public Page<BookDTO> getBooksByPage(int page) {
		Page<Book> entities = bookRepository.findAll(getBookEntitesByPage(page));
		Page<BookDTO> books = entities.map(entity -> {
			BookDTO dto = bookConverter.toDTO(entity);
			return dto;
		});
		return books;
	}

	@Override
	public Page<BookDTO> search(String bookName, String authorName, int page) {

		Pageable pageable = PageRequest.of(page, size);

		Page<Book> entities = bookRepository.search(bookName, authorName, pageable);

		Page<BookDTO> books = entities.map(entity -> {
			BookDTO dto = bookConverter.toDTO(entity);
			return dto;
		});
		return books;

	}


}
