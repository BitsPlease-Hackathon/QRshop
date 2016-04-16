package com.bitsplease.qrshop.service.system;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.domain.resository.system.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product update(Product product, String id) {
        if(!productRepository.exists(id)) throw new EntityNotFoundException();

        if (!Objects.equals(id, product.getId())) delete(id);

        return create(product);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }
}


