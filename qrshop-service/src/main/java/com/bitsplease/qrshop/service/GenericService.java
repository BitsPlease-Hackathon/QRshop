package com.bitsplease.qrshop.service;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface GenericService<T, D> {

    List<T> findAll();

    T findOne(String id);

    T update(D entity, String id);

    T create(D entity);

    void delete(String id);
}
