package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    private UserService userService;

    //Creating user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        User user1 = userService.createUser(user, roles);

        return user1;
    }


}
