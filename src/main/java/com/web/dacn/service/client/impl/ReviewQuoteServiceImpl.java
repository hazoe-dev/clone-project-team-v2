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

import com.web.dacn.entity.quote.ReviewQuote;
import com.web.dacn.repository.ReviewQuoteRepository;
import com.web.dacn.service.client.ReviewQuoteService;

@Service
public class ReviewQuoteServiceImpl implements ReviewQuoteService {
	@Autowired
	private ReviewQuoteRepository reviewQuoteRepository;
	
	@Override
	public Optional<ReviewQuote> findByUserIdAndQuoteId(Long userId, Long QuoteId) {
		return reviewQuoteRepository.findByUserIdAndQuoteId(userId, QuoteId);
	}

	@Override
	public <S extends ReviewQuote> S save(S entity) {
		return reviewQuoteRepository.save(entity);
	}

	@Override
	public <S extends ReviewQuote> Optional<S> findOne(Example<S> example) {
		return reviewQuoteRepository.findOne(example);
	}

	@Override
	public List<ReviewQuote> findAll() {
		return reviewQuoteRepository.findAll();
	}

	@Override
	public Page<ReviewQuote> findAll(Pageable pageable) {
		return reviewQuoteRepository.findAll(pageable);
	}

	@Override
	public List<ReviewQuote> findAll(Sort sort) {
		return reviewQuoteRepository.findAll(sort);
	}

	@Override
	public List<ReviewQuote> findAllById(Iterable<Long> ids) {
		return reviewQuoteRepository.findAllById(ids);
	}

	@Override
	public Optional<ReviewQuote> findById(Long id) {
		return reviewQuoteRepository.findById(id);
	}

	@Override
	public <S extends ReviewQuote> List<S> saveAll(Iterable<S> entities) {
		return reviewQuoteRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		reviewQuoteRepository.flush();
	}

	@Override
	public <S extends ReviewQuote> S saveAndFlush(S entity) {
		return reviewQuoteRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return reviewQuoteRepository.existsById(id);
	}

	@Override
	public <S extends ReviewQuote> List<S> saveAllAndFlush(Iterable<S> entities) {
		return reviewQuoteRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ReviewQuote> Page<S> findAll(Example<S> example, Pageable pageable) {
		return reviewQuoteRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ReviewQuote> entities) {
		reviewQuoteRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ReviewQuote> long count(Example<S> example) {
		return reviewQuoteRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ReviewQuote> entities) {
		reviewQuoteRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return reviewQuoteRepository.count();
	}

	@Override
	public <S extends ReviewQuote> boolean exists(Example<S> example) {
		return reviewQuoteRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		reviewQuoteRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		reviewQuoteRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ReviewQuote entity) {
		reviewQuoteRepository.delete(entity);
	}

	@Override
	public <S extends ReviewQuote, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return reviewQuoteRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		reviewQuoteRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		reviewQuoteRepository.deleteAllInBatch();
	}

	@Override
	public ReviewQuote getOne(Long id) {
		return reviewQuoteRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ReviewQuote> entities) {
		reviewQuoteRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		reviewQuoteRepository.deleteAll();
	}

	@Override
	public ReviewQuote getById(Long id) {
		return reviewQuoteRepository.getById(id);
	}

	@Override
	public <S extends ReviewQuote> List<S> findAll(Example<S> example) {
		return reviewQuoteRepository.findAll(example);
	}

	@Override
	public <S extends ReviewQuote> List<S> findAll(Example<S> example, Sort sort) {
		return reviewQuoteRepository.findAll(example, sort);
	}
	
	
	
}
