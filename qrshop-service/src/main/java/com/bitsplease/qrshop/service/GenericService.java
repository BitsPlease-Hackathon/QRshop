package com.bitsplease.qrshop.service;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface GenericService<T> {

    List<T> findAll();

    T findOne(String id);

    T update(T entity, String id);

    T create(T entity);

    void delete(String id);
}
