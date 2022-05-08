package com.web.dacn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.quote.QuoteCategory;

@Repository
public interface QuoteCategoryRepository extends JpaRepository<QuoteCategory, Long> {
	Page<QuoteCategory> findByNameContaining(String name, Pageable pageable);
}
