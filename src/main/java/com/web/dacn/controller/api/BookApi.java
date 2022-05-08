package com.web.dacn.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dacn.dto.book.BookCategoryDTO;
import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.book.OnlineDTO;
import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.entity.book.Book;
import com.web.dacn.repository.BookRepository;
import com.web.dacn.repository.OnlineRepository;
import com.web.dacn.service.client.ReadOnlineService;

@RestController(value = "/test/books")
public class BookApi {
	@Autowired
	private OnlineRepository onlineRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable int id) {
		return ResponseEntity.ok(onlineRepository.existsByBookId(id));
	}
	
}
