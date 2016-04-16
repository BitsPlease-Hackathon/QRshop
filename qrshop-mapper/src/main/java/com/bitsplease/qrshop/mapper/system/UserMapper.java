package com.bitsplease.qrshop.mapper.system;

import com.bitsplease.qrshop.domain.entity.system.User;
import com.bitsplease.qrshop.dto.system.UserDto;
import com.bitsplease.qrshop.mapper.GenericMapper;
import com.bitsplease.qrshop.mapper.embeddable.NameMapper;
import org.mapstruct.Mapper;

/**
 * @author Chrisostomos Bakouras
 */
@Mapper(uses = NameMapper.class)
public interface UserMapper extends GenericMapper<UserDto, User> {
}
