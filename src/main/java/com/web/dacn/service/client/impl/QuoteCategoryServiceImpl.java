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

import com.web.dacn.entity.quote.QuoteCategory;
import com.web.dacn.repository.QuoteCategoryRepository;
import com.web.dacn.service.client.QuoteCategoryService;

@Service
public class QuoteCategoryServiceImpl implements QuoteCategoryService {
	@Autowired
	private QuoteCategoryRepository quoteCategoryRepository;

	@Override
	public Page<QuoteCategory> findByNameContaining(String name, Pageable pageable) {
		return quoteCategoryRepository.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends QuoteCategory> S save(S entity) {
		return quoteCategoryRepository.save(entity);
	}

	@Override
	public <S extends QuoteCategory> Optional<S> findOne(Example<S> example) {
		return quoteCategoryRepository.findOne(example);
	}

	@Override
	public List<QuoteCategory> findAll() {
		return quoteCategoryRepository.findAll();
	}

	@Override
	public Page<QuoteCategory> findAll(Pageable pageable) {
		return quoteCategoryRepository.findAll(pageable);
	}

	@Override
	public List<QuoteCategory> findAll(Sort sort) {
		return quoteCategoryRepository.findAll(sort);
	}

	@Override
	public List<QuoteCategory> findAllById(Iterable<Long> ids) {
		return quoteCategoryRepository.findAllById(ids);
	}

	@Override
	public Optional<QuoteCategory> findById(Long id) {
		return quoteCategoryRepository.findById(id);
	}

	@Override
	public <S extends QuoteCategory> List<S> saveAll(Iterable<S> entities) {
		return quoteCategoryRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		quoteCategoryRepository.flush();
	}

	@Override
	public <S extends QuoteCategory> S saveAndFlush(S entity) {
		return quoteCategoryRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return quoteCategoryRepository.existsById(id);
	}

	@Override
	public <S extends QuoteCategory> List<S> saveAllAndFlush(Iterable<S> entities) {
		return quoteCategoryRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends QuoteCategory> Page<S> findAll(Example<S> example, Pageable pageable) {
		return quoteCategoryRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<QuoteCategory> entities) {
		quoteCategoryRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends QuoteCategory> long count(Example<S> example) {
		return quoteCategoryRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<QuoteCategory> entities) {
		quoteCategoryRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return quoteCategoryRepository.count();
	}

	@Override
	public <S extends QuoteCategory> boolean exists(Example<S> example) {
		return quoteCategoryRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		quoteCategoryRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		quoteCategoryRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(QuoteCategory entity) {
		quoteCategoryRepository.delete(entity);
	}

	@Override
	public <S extends QuoteCategory, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		return quoteCategoryRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		quoteCategoryRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		quoteCategoryRepository.deleteAllInBatch();
	}

	@Override
	public QuoteCategory getOne(Long id) {
		return quoteCategoryRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends QuoteCategory> entities) {
		quoteCategoryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		quoteCategoryRepository.deleteAll();
	}

	@Override
	public QuoteCategory getById(Long id) {
		return quoteCategoryRepository.getById(id);
	}

	@Override
	public <S extends QuoteCategory> List<S> findAll(Example<S> example) {
		return quoteCategoryRepository.findAll(example);
	}

	@Override
	public <S extends QuoteCategory> List<S> findAll(Example<S> example, Sort sort) {
		return quoteCategoryRepository.findAll(example, sort);
	}
	
	
}
