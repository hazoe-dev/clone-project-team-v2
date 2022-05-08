package com.web.dacn.service.client;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.web.dacn.entity.quote.CommentQuote;

public interface CommentQuoteService {

	<S extends CommentQuote> List<S> findAll(Example<S> example, Sort sort);

	<S extends CommentQuote> List<S> findAll(Example<S> example);

	CommentQuote getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends CommentQuote> entities);

	CommentQuote getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends CommentQuote, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(CommentQuote entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends CommentQuote> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<CommentQuote> entities);

	<S extends CommentQuote> long count(Example<S> example);

	void deleteInBatch(Iterable<CommentQuote> entities);

	<S extends CommentQuote> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CommentQuote> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends CommentQuote> S saveAndFlush(S entity);

	void flush();

	<S extends CommentQuote> List<S> saveAll(Iterable<S> entities);

	Optional<CommentQuote> findById(Long id);

	List<CommentQuote> findAllById(Iterable<Long> ids);

	List<CommentQuote> findAll(Sort sort);

	Page<CommentQuote> findAll(Pageable pageable);

	List<CommentQuote> findAll();

	<S extends CommentQuote> Optional<S> findOne(Example<S> example);

	<S extends CommentQuote> S save(S entity);

	List<CommentQuote> findByQuoteId(Long quoteId);

}
