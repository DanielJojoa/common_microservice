package com.danieljojoa.microservicios.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E,R extends CrudRepository<E,Long>> implements CommonService <E>{
	
	@Autowired
	protected R reposotory;
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		
		return reposotory.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return reposotory.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return reposotory.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		reposotory.deleteById(id);

	}

}
