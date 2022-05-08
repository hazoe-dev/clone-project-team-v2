package com.web.dacn.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.dacn.dto.book.BookDTO;

@Service
public interface IBookService {

	Page<BookDTO> getBooksByPage(int page);

	List<String> getReadFromat(long bookId);

	Page<BookDTO> search(String bookName, String authorName, int page);
  
	
}
