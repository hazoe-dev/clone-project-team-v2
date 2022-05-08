package com.web.dacn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.dacn.entity.quote.FavoriteQuote;

@Repository
public interface FavoriteQuoteRepository extends JpaRepository<FavoriteQuote, Long>{

}
