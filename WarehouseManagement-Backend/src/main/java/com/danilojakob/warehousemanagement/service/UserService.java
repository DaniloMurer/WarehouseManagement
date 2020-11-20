package com.danilojakob.warehousemanagement.service;

import com.danilojakob.warehousemanagement.domain.Role;
import com.danilojakob.warehousemanagement.domain.User;
import com.danilojakob.warehousemanagement.dtos.SignUpDto;
import com.danilojakob.warehousemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User Service
 * @copyright Danilo Jakob
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    /**
     * Repository to access data from service
     */
    private final UserRepository userRepository;

    public User createUserFrom(SignUpDto signUpDto) {

        List<Role> roles = roleService.findByNames(signUpDto.getRoles());
        if(roles.isEmpty()){
            roles.add(roleService.getDefaultRole());
        }

        return new User(
                signUpDto.getUsername(),
                bCryptPasswordEncoder.encode(signUpDto.getPassword()),
                roles
        );
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
