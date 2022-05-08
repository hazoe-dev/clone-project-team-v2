package com.web.dacn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.quote.CommentQuote;

@Repository
public interface CommentQuoteRepository extends JpaRepository<CommentQuote, Long>{
	List<CommentQuote> findByQuoteId(Long quoteId);
}
