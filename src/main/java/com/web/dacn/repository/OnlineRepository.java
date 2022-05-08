package com.web.dacn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.book.Online;

@Repository
public interface OnlineRepository extends JpaRepository<Online, Long>{
	List<Online> findByBookId(long  bookId);
	boolean existsByBookId(long bookId);	
	List<Online> findByBookIdOrderByPriorityAsc(long bookId, Pageable pageable);
}
