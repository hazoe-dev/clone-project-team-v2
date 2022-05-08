package com.web.dacn.service.client;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.web.dacn.entity.quote.QuoteCategory;

public interface QuoteCategoryService {

	<S extends QuoteCategory> List<S> findAll(Example<S> example, Sort sort);

	<S extends QuoteCategory> List<S> findAll(Example<S> example);

	QuoteCategory getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends QuoteCategory> entities);

	QuoteCategory getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends QuoteCategory, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(QuoteCategory entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends QuoteCategory> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<QuoteCategory> entities);

	<S extends QuoteCategory> long count(Example<S> example);

	void deleteInBatch(Iterable<QuoteCategory> entities);

	<S extends QuoteCategory> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends QuoteCategory> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends QuoteCategory> S saveAndFlush(S entity);

	void flush();

	<S extends QuoteCategory> List<S> saveAll(Iterable<S> entities);

	Optional<QuoteCategory> findById(Long id);

	List<QuoteCategory> findAllById(Iterable<Long> ids);

	List<QuoteCategory> findAll(Sort sort);

	Page<QuoteCategory> findAll(Pageable pageable);

	List<QuoteCategory> findAll();

	<S extends QuoteCategory> Optional<S> findOne(Example<S> example);

	<S extends QuoteCategory> S save(S entity);

	Page<QuoteCategory> findByNameContaining(String name, Pageable pageable);

}
