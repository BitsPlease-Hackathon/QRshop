package com.bitsplease.qrshop.security;

import com.bitsplease.qrshop.domain.entity.system.User;
import com.bitsplease.qrshop.domain.resository.system.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Chrisostomos Bakouras
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new CurrentUser(user);
    }
}
