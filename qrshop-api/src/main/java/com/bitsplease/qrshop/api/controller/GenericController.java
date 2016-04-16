package com.bitsplease.qrshop.api.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface GenericController<T> {

    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getOne(String id);

    ResponseEntity<T> post(T dto);

    ResponseEntity<T> put(T dto, String id);

    ResponseEntity<Void> delete(String id);
}
