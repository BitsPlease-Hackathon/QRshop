package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.Order;
import com.bitsplease.qrshop.dto.Reference;
import com.bitsplease.qrshop.dto.system.OrderDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import com.bitsplease.qrshop.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = {
        OrderDetailMapper.class,
        ReferenceMapper.class
} )
public interface OrderMapper extends GenericMapper<OrderDto, Order> {
}
