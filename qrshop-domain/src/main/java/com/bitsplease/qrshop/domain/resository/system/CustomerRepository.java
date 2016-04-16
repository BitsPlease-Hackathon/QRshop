package com.bitsplease.qrshop.domain.resository.system;

import com.bitsplease.qrshop.domain.entity.system.Customer;
import com.bitsplease.qrshop.domain.resository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface CustomerRepository extends GenericRepository<Customer> {
}
