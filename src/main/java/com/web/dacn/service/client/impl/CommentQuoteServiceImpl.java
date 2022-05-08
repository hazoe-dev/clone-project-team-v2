package com.web.dacn.service.client.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.web.dacn.entity.quote.CommentQuote;
import com.web.dacn.repository.CommentQuoteRepository;
import com.web.dacn.service.client.CommentQuoteService;

@Service
public class CommentQuoteServiceImpl implements CommentQuoteService{
	@Autowired
	private CommentQuoteRepository commentQuoteRepository;
	
	@Override
	public List<CommentQuote> findByQuoteId(Long quoteId) {
		return commentQuoteRepository.findByQuoteId(quoteId);
	}

	@Override
	public <S extends CommentQuote> S save(S entity) {
		return commentQuoteRepository.save(entity);
	}

	@Override
	public <S extends CommentQuote> Optional<S> findOne(Example<S> example) {
		return commentQuoteRepository.findOne(example);
	}

	@Override
	public List<CommentQuote> findAll() {
		return commentQuoteRepository.findAll();
	}

	@Override
	public Page<CommentQuote> findAll(Pageable pageable) {
		return commentQuoteRepository.findAll(pageable);
	}

	@Override
	public List<CommentQuote> findAll(Sort sort) {
		return commentQuoteRepository.findAll(sort);
	}

	@Override
	public List<CommentQuote> findAllById(Iterable<Long> ids) {
		return commentQuoteRepository.findAllById(ids);
	}

	@Override
	public Optional<CommentQuote> findById(Long id) {
		return commentQuoteRepository.findById(id);
	}

	@Override
	public <S extends CommentQuote> List<S> saveAll(Iterable<S> entities) {
		return commentQuoteRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		commentQuoteRepository.flush();
	}

	@Override
	public <S extends CommentQuote> S saveAndFlush(S entity) {
		return commentQuoteRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return commentQuoteRepository.existsById(id);
	}

	@Override
	public <S extends CommentQuote> List<S> saveAllAndFlush(Iterable<S> entities) {
		return commentQuoteRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CommentQuote> Page<S> findAll(Example<S> example, Pageable pageable) {
		return commentQuoteRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<CommentQuote> entities) {
		commentQuoteRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends CommentQuote> long count(Example<S> example) {
		return commentQuoteRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CommentQuote> entities) {
		commentQuoteRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return commentQuoteRepository.count();
	}

	@Override
	public <S extends CommentQuote> boolean exists(Example<S> example) {
		return commentQuoteRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		commentQuoteRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		commentQuoteRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(CommentQuote entity) {
		commentQuoteRepository.delete(entity);
	}

	@Override
	public <S extends CommentQuote, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return commentQuoteRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		commentQuoteRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		commentQuoteRepository.deleteAllInBatch();
	}

	@Override
	public CommentQuote getOne(Long id) {
		return commentQuoteRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends CommentQuote> entities) {
		commentQuoteRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		commentQuoteRepository.deleteAll();
	}

	@Override
	public CommentQuote getById(Long id) {
		return commentQuoteRepository.getById(id);
	}

	@Override
	public <S extends CommentQuote> List<S> findAll(Example<S> example) {
		return commentQuoteRepository.findAll(example);
	}

	@Override
	public <S extends CommentQuote> List<S> findAll(Example<S> example, Sort sort) {
		return commentQuoteRepository.findAll(example, sort);
	}
	
	
}
