package com.bitsplease.qrshop.service.system;

import com.bitsplease.qrshop.domain.entity.system.Customer;
import com.bitsplease.qrshop.domain.resository.system.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOne(String id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer update(Customer customer, String id) {
        if (!customerRepository.exists(id)) throw new EntityNotFoundException();

        if (!Objects.equals(id, customer.getId())) delete(id);

        return create(customer);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.delete(id);
    }
}
