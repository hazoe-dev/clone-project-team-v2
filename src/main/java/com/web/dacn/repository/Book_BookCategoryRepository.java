package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.dacn.entity.book.Book_BookCategory;

public interface Book_BookCategoryRepository extends JpaRepository<Book_BookCategory, Long> {
	
}
