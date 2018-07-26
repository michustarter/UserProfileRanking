package com.capgemini.dataaccess.repository;

import java.util.List;

public interface CrudDAO<T, PK> {
	
	/*
	 CReate--> save  Update Delete
	 + find dodatotkowo 
	 
	 */

    T save(T t);

    T findByID(PK primaryKey);

    T update(T t);

    void delete(PK primaryKey);

    List<T> findAll();
}
