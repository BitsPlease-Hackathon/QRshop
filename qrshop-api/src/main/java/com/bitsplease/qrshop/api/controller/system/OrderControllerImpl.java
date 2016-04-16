package com.bitsplease.qrshop.api.controller.system;

import com.bitsplease.qrshop.domain.entity.system.Order;
import com.bitsplease.qrshop.dto.system.OrderDto;
import com.bitsplease.qrshop.dto.system.ProductDto;
import com.bitsplease.qrshop.mapper.system.OrderMapper;
import com.bitsplease.qrshop.service.system.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Chrisostomos Bakouras
 */
@RestController
@RequestMapping("/orders")
public class OrderControllerImpl implements OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @Override
    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getAll() {
        List<Order> orders = orderService.findAll();

        List<OrderDto> orderDtos = orderMapper.allToDto(orders);

        return ResponseEntity.ok(orderDtos);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getOne(@PathVariable String id) {
        Order order = orderService.findOne(id);

        OrderDto orderDto = orderMapper.toDto(order);

        return ResponseEntity.ok(orderDto);
    }

    @Override
    @RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> post(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.fromDto(orderDto);

        Order createdOrder = orderService.create(order);

        URI location = linkTo(methodOn(OrderControllerImpl.class).getOne(createdOrder.getId())).toUri();

        OrderDto createdOrderDto = orderMapper.toDto(createdOrder);

        return ResponseEntity
                .created(location)
                .body(createdOrderDto);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> put(@RequestBody OrderDto dto, @PathVariable String id) {
        Order order = orderMapper.fromDto(dto);

        Order updatedOrder = orderService.update(order, id);

        OrderDto updatedOrderDto = orderMapper.toDto(updatedOrder);

        return ResponseEntity.ok(updatedOrderDto);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        orderService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
