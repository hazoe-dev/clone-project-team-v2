package com.web.dacn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.quote.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>{
	Page<Quote> findByContentContaining(String content, Pageable pageable);
	Page<Quote> findAllByContentContainingAndQuoteCategories_slug(String content,String categorySlug, Pageable pageable);
}
