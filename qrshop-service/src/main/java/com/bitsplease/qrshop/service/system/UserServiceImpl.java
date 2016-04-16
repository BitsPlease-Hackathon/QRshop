package com.bitsplease.qrshop.service.system;

import com.bitsplease.qrshop.domain.entity.system.User;
import com.bitsplease.qrshop.domain.resository.system.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User user, String id) {
        if (!userRepository.exists(id)) throw new EntityNotFoundException();

        if (!Objects.equals(id, user.getId())) delete(id);

        return create(user);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
