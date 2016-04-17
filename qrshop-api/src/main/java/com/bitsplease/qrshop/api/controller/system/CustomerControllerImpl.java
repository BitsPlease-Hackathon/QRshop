package com.bitsplease.qrshop.api.controller.system;

import com.bitsplease.qrshop.domain.entity.system.Customer;
import com.bitsplease.qrshop.dto.system.CustomerDto;
import com.bitsplease.qrshop.mapper.system.CustomerMapper;
import com.bitsplease.qrshop.service.system.CustomerService;
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
@RequestMapping("/customers")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers = customerService.findAll();

        List<CustomerDto> customerDtos = customerMapper.allToDto(customers);

        return ResponseEntity.ok(customerDtos);
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> getOne(@PathVariable String id) {
        Customer customer = customerService.findOne(id);

        CustomerDto customerDto = customerMapper.toDto(customer);

        return ResponseEntity.ok(customerDto);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> post(@RequestBody CustomerDto customerDto) {
        Customer customer = customerMapper.fromDto(customerDto);

        Customer createdCustomer = customerService.create(customer);

        URI location = linkTo(methodOn(CustomerControllerImpl.class).getOne(createdCustomer.getId())).toUri();

        CustomerDto createdCustomerDto = customerMapper.toDto(createdCustomer);

        return ResponseEntity
                .created(location)
                .body(createdCustomerDto);
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> put(@RequestBody CustomerDto dto, @PathVariable String id) {
        Customer customer = customerMapper.fromDto(dto);

        Customer updatedCustomer = customerService.update(customer, id);

        CustomerDto updatedCustomerDto = customerMapper.toDto(updatedCustomer);

        return ResponseEntity.ok(updatedCustomerDto);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
