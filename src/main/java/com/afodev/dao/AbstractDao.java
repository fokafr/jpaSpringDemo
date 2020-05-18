package com.afodev.dao;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDao<T> {
  
	public abstract EntityManager getEm();
	
	public T save(T entity) {
		getEm().persist(entity);
		return entity;
	}
	
	public void update(Class<T> clazz, Long id) {
		T p = getEm().find(clazz, id);
		getEm().merge(p);		
	}
}
