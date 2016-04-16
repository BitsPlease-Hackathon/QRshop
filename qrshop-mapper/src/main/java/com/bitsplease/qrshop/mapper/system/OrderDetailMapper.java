package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.OrderDetail;
import com.bitsplease.qrshop.dto.system.OrderDetailDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import com.bitsplease.qrshop.mapper.ReferenceMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = ReferenceMapper.class)
public interface OrderDetailMapper extends GenericMapper<OrderDetailDto, OrderDetail> {
}
