package com.bitsplease.qrshop.api.controller.system;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.dto.system.ProductDto;
import com.bitsplease.qrshop.mapper.system.ProductMapper;
import com.bitsplease.qrshop.service.system.ProductService;
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
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Override
    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.findAll();

        List<ProductDto> productDtos = productMapper.allToDto(products);

        return ResponseEntity.ok(productDtos);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getOne(@PathVariable String id) {
        Product product = productService.findOne(id);

        ProductDto productDto = productMapper.toDto(product);

        return ResponseEntity.ok(productDto);
    }

    @Override
    @RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> post(@RequestBody ProductDto dto) {
        Product product = productMapper.fromDto(dto);

        Product createdProduct = productService.create(product);

        URI location = linkTo(methodOn(ProductControllerImpl.class).getOne(createdProduct.getId())).toUri();

        ProductDto createdProductDto = productMapper.toDto(createdProduct);

        return ResponseEntity
                .created(location)
                .body(createdProductDto);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> put(@RequestBody ProductDto dto, @PathVariable String id) {
        Product product = productMapper.fromDto(dto);

        Product updatedProduct = productService.update(product, id);

        ProductDto updatedProductDto = productMapper.toDto(updatedProduct);

        return ResponseEntity.ok(updatedProductDto);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
