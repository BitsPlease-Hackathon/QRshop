package com.bitsplease.qrshop.mapper.embeddable;

import com.bitsplease.qrshop.domain.entity.embeddable.Name;
import com.bitsplease.qrshop.dto.embeddable.NameDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper
public interface NameMapper extends GenericMapper<NameDto, Name> {
}
