package com.bitsplease.qrshop.domain.resository.system;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.domain.resository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface ProductRepository extends GenericRepository<Product> {
}
