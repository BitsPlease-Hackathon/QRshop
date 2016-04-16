package com.bitsplease.qrshop.mapper;

import java.util.List;

/**
 * @author Chrisostomos Bakouras
 */
public interface GenericMapper<D, T> {
    D toDto(T target);
    T fromDto(D dto);
    List<D> allToDto(List<T> targets);
    List<T> allFromDto(List<D> dtos);
}
