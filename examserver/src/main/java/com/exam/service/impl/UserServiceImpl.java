package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepo.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User already exist!!");
            throw new Exception("User aleardy present!!");
        } else {
            for (UserRole ur : userRoles) {
                roleRepo.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
//            local = this.userRepo.save(user);
        }
        return local;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }
}
