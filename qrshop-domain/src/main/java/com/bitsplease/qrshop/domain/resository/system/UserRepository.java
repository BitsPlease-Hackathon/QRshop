package com.bitsplease.qrshop.domain.resository.system;

import com.bitsplease.qrshop.domain.entity.system.User;
import com.bitsplease.qrshop.domain.resository.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chrisostomos Bakouras
 */
@Repository
public interface UserRepository extends GenericRepository<User> {
    User findByUsername(String username);
}
