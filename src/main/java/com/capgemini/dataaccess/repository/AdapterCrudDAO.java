package com.capgemini.dataaccess.repository;

import java.util.List;

public abstract class AdapterCrudDAO<T, PK> implements CrudDAO<T, PK> {
    @Override
    public T save(T t) {
        throw new UnsupportedOperationException("Method save is not yet implemented!");
    }

    @Override
    public T findByID(PK primaryKey) {
        throw new UnsupportedOperationException("Method find is not yet implemented!");
    }

    @Override
    public T update(T t) {
        throw new UnsupportedOperationException("Method update is not yet implemented!");
    }

    @Override
    public void delete(PK primaryKey) {
        throw new UnsupportedOperationException("Method delete is not yet implemented!");
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Method findAll is not yet implemented!");
    }
}
