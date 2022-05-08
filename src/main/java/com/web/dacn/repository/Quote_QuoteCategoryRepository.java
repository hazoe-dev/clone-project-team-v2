package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.quote.Quote_QuoteCategory;

@Repository
public interface Quote_QuoteCategoryRepository extends JpaRepository<Quote_QuoteCategory, Long>{

}
