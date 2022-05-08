package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.book.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long>{
	
	
}
