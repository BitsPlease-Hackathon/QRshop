package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.Customer;
import com.bitsplease.qrshop.dto.system.CustomerDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import com.bitsplease.qrshop.mapper.ReferenceMapper;
import com.bitsplease.qrshop.mapper.embeddable.AddressMapper;
import com.bitsplease.qrshop.mapper.embeddable.NameMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = {
        ReferenceMapper.class,
        AddressMapper.class,
        NameMapper.class
})
public interface CustomerMapper extends GenericMapper<CustomerDto, Customer> {
}
