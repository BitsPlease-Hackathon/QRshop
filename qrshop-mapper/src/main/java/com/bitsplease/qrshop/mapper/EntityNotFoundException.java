package com.bitsplease.qrshop.mapper;

/**
 * @author Chrisostomos Bakouras
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class<?> entityClass, String fieldName, String value) {
        super(entityClass.getSimpleName() + " with " + fieldName + " = " + value + " not found");
    }
}
