package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.book.CommentBook;

@Repository
public interface CommentBookRepository extends JpaRepository<CommentBook, Long> {

}
