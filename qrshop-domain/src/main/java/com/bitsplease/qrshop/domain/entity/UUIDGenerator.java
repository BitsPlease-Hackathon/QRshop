package com.bitsplease.qrshop.domain.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Chrisostomos Bakouras
 */
public class UUIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object object) throws HibernateException {
        return UUID.randomUUID().toString();
    }
}
