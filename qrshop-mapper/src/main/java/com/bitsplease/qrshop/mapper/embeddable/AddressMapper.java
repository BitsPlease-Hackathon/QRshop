package com.bitsplease.qrshop.mapper.embeddable;

import com.bitsplease.qrshop.domain.entity.embeddable.Address;
import com.bitsplease.qrshop.dto.embeddable.AddressDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper
public interface AddressMapper extends GenericMapper<AddressDto, Address> {
}
