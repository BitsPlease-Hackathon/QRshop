package com.bitsplease.qrshop.domain.resository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Chrisostomos Bakouras
 */
@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, String> {
}
