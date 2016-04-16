package com.bitsplease.qrshop.api.controller.system;

import com.bitsplease.qrshop.domain.entity.system.User;
import com.bitsplease.qrshop.dto.system.UserDto;
import com.bitsplease.qrshop.mapper.system.UserMapper;
import com.bitsplease.qrshop.service.system.UserService;
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
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.findAll();

        List<UserDto> userDtos = userMapper.allToDto(users);

        return ResponseEntity.ok(userDtos);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getOne(@PathVariable String id) {
        User user = userService.findOne(id);

        UserDto userDto = userMapper.toDto(user);

        return ResponseEntity.ok(userDto);
    }

    @Override
    @RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> post(@RequestBody UserDto dto) {
        User user = userMapper.fromDto(dto);

        User createdUser = userService.create(user);

        URI location = linkTo(methodOn(UserControllerImpl.class).getOne(createdUser.getId())).toUri();

        UserDto createdUserDto = userMapper.toDto(createdUser);

        return ResponseEntity
                .created(location)
                .body(createdUserDto);
    }

    @Override
    @RequestMapping(path = "/{id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> put(@RequestBody UserDto dto, @PathVariable String id) {
        User user = userMapper.fromDto(dto);

        User updatedUser = userService.update(user, id);

        UserDto updatedUserDto = userMapper.toDto(updatedUser);

        return ResponseEntity.ok(updatedUserDto);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
