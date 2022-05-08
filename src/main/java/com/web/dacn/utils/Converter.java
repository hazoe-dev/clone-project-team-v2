package com.web.dacn.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.web.dacn.dto.book.BookCategoryDTO;
import com.web.dacn.dto.book.BookDTO;
import com.web.dacn.dto.user.AuthorDTO;
import com.web.dacn.entity.book.Book;
import com.web.dacn.entity.book.BookCategory;
import com.web.dacn.entity.user.Author;

@Component
public class Converter {
	public AuthorDTO toDTO(Author entity) {
		AuthorDTO author = new AuthorDTO();
		author.setFullname(entity.getFullname());
		author.setId(entity.getId());
		return author;

	}

	public BookCategoryDTO toDTO(BookCategory entity) {
		BookCategoryDTO category = new BookCategoryDTO();
		category.setId(entity.getId());
		category.setName(entity.getName());

		return category;
	}

	public BookDTO toDTO(Book entity) {

		BookDTO book = new BookDTO();
		
		book.setId(entity.getId());
		book.setName(entity.getName());
		book.setStatus(entity.getStatus());
		book.setThumbnail(entity.getThumbnail());
		book.setMod_time(entity.getMod_time());

		for (BookCategory category : entity.getCategories()) {
			BookCategoryDTO dto = toDTO(category);
			book.getCategories().add(dto);
		}

		for (Author author : entity.getAuthors()) {
			AuthorDTO dto = toDTO(author);
			book.getAuthors().add(dto);

		}

		return book;
	}
}
