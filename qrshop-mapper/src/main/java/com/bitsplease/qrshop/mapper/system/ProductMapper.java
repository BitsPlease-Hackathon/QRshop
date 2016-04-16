package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.Product;
import com.bitsplease.qrshop.dto.system.ProductDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductDto, Product> {
}
