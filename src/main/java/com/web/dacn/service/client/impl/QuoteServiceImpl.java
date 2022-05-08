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

import com.web.dacn.entity.quote.Quote;
import com.web.dacn.repository.QuoteRepository;
import com.web.dacn.service.client.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {
	@Autowired
	private QuoteRepository quoteRepository;

	@Override
	public Page<Quote> findAllByContentContainingAndQuoteCategories_slug(String content, String categorySlug,
			Pageable pageable) {
		return quoteRepository.findAllByContentContainingAndQuoteCategories_slug(content, categorySlug, pageable);
	}

	@Override
	public Page<Quote> findByContentContaining(String content, Pageable pageable) {
		return quoteRepository.findByContentContaining(content, pageable);
	}
	
	@Override
	public <S extends Quote> S save(S entity) {
		return quoteRepository.save(entity);
	}

	@Override
	public <S extends Quote> Optional<S> findOne(Example<S> example) {
		return quoteRepository.findOne(example);
	}

	@Override
	public List<Quote> findAll() {
		return quoteRepository.findAll();
	}

	@Override
	public Page<Quote> findAll(Pageable pageable) {
		return quoteRepository.findAll(pageable);
	}

	@Override
	public List<Quote> findAll(Sort sort) {
		return quoteRepository.findAll(sort);
	}

	@Override
	public List<Quote> findAllById(Iterable<Long> ids) {
		return quoteRepository.findAllById(ids);
	}

	@Override
	public Optional<Quote> findById(Long id) {
		return quoteRepository.findById(id);
	}

	@Override
	public <S extends Quote> List<S> saveAll(Iterable<S> entities) {
		return quoteRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		quoteRepository.flush();
	}

	@Override
	public <S extends Quote> S saveAndFlush(S entity) {
		return quoteRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return quoteRepository.existsById(id);
	}

	@Override
	public <S extends Quote> List<S> saveAllAndFlush(Iterable<S> entities) {
		return quoteRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Quote> Page<S> findAll(Example<S> example, Pageable pageable) {
		return quoteRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Quote> entities) {
		quoteRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Quote> long count(Example<S> example) {
		return quoteRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Quote> entities) {
		quoteRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return quoteRepository.count();
	}

	@Override
	public <S extends Quote> boolean exists(Example<S> example) {
		return quoteRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		quoteRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		quoteRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Quote entity) {
		quoteRepository.delete(entity);
	}

	@Override
	public <S extends Quote, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return quoteRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		quoteRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		quoteRepository.deleteAllInBatch();
	}

	@Override
	public Quote getOne(Long id) {
		return quoteRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Quote> entities) {
		quoteRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		quoteRepository.deleteAll();
	}

	@Override
	public Quote getById(Long id) {
		return quoteRepository.getById(id);
	}

	@Override
	public <S extends Quote> List<S> findAll(Example<S> example) {
		return quoteRepository.findAll(example);
	}

	@Override
	public <S extends Quote> List<S> findAll(Example<S> example, Sort sort) {
		return quoteRepository.findAll(example, sort);
	}
	
	
}
