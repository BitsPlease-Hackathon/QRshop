package com.bitsplease.qrshop.service.system;

import com.bitsplease.qrshop.domain.entity.system.Order;
import com.bitsplease.qrshop.domain.resository.system.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOne(String id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order update(Order order, String id) {
        if (!orderRepository.exists(id)) throw new EntityNotFoundException();

        if (!Objects.equals(id, order.getId())) delete(id);

        return create(order);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(String id) {
        orderRepository.delete(id);
    }
}
