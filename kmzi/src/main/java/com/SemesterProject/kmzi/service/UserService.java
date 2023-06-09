package com.SemesterProject.kmzi.service;



import com.SemesterProject.kmzi.entity.Role;
import com.SemesterProject.kmzi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.SemesterProject.kmzi.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createAdminUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles(List.of(new Role(), new Role()));
        userRepository.save(user);
    }

    public Role findRoleByName(String roleUser) {
        return userRepository.findByRoleName(roleUser).get().getRoles().get(0);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        if(userRepository.findByEmail(email).isEmpty()){
            return null;
        } else {
            return userRepository.findByEmail(email).get();
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

