package com.web.dacn.service.client;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.web.dacn.entity.quote.ReviewQuote;

public interface ReviewQuoteService {

	<S extends ReviewQuote> List<S> findAll(Example<S> example, Sort sort);

	<S extends ReviewQuote> List<S> findAll(Example<S> example);

	ReviewQuote getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends ReviewQuote> entities);

	ReviewQuote getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends ReviewQuote, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(ReviewQuote entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends ReviewQuote> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<ReviewQuote> entities);

	<S extends ReviewQuote> long count(Example<S> example);

	void deleteInBatch(Iterable<ReviewQuote> entities);

	<S extends ReviewQuote> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ReviewQuote> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends ReviewQuote> S saveAndFlush(S entity);

	void flush();

	<S extends ReviewQuote> List<S> saveAll(Iterable<S> entities);

	Optional<ReviewQuote> findById(Long id);

	List<ReviewQuote> findAllById(Iterable<Long> ids);

	List<ReviewQuote> findAll(Sort sort);

	Page<ReviewQuote> findAll(Pageable pageable);

	List<ReviewQuote> findAll();

	<S extends ReviewQuote> Optional<S> findOne(Example<S> example);

	<S extends ReviewQuote> S save(S entity);

	Optional<ReviewQuote> findByUserIdAndQuoteId(Long userId, Long QuoteId);

}
