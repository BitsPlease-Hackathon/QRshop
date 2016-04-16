package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.Order;
import com.bitsplease.qrshop.dto.system.OrderDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = OrderDetailMapper.class)
public interface OrderMapper extends GenericMapper<OrderDto, Order> {
}
