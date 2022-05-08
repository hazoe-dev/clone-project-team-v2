package com.web.dacn.service.client;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.web.dacn.entity.quote.Quote;

public interface QuoteService {

	<S extends Quote> List<S> findAll(Example<S> example, Sort sort);

	<S extends Quote> List<S> findAll(Example<S> example);

	Quote getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Quote> entities);

	Quote getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Quote, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Quote entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Quote> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Quote> entities);

	<S extends Quote> long count(Example<S> example);

	void deleteInBatch(Iterable<Quote> entities);

	<S extends Quote> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Quote> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Quote> S saveAndFlush(S entity);

	void flush();

	<S extends Quote> List<S> saveAll(Iterable<S> entities);

	Optional<Quote> findById(Long id);

	List<Quote> findAllById(Iterable<Long> ids);

	List<Quote> findAll(Sort sort);

	Page<Quote> findAll(Pageable pageable);

	List<Quote> findAll();

	<S extends Quote> Optional<S> findOne(Example<S> example);

	<S extends Quote> S save(S entity);

	Page<Quote> findByContentContaining(String content, Pageable pageable);

	Page<Quote> findAllByContentContainingAndQuoteCategories_slug(String content, String categorySlug, Pageable pageable);

}
