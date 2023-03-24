package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code...");

		User user = new User();
		user.setUsername("devendra4");
		user.setFirstName("Devendra");
		user.setLastName("Kumar");
		user.setEmail("dev@gmail.com");
		user.setPhone("7055059432");
		user.setPassword("abc");
		user.setProfile("default.png");

		Role role1 = new Role();
		role1.setRoleName("Admin");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoles.add(userRole);

//		User user1 = userService.createUser(user, userRoles);
//		System.out.println(user1.getUsername());

		List<User> allUsers = this.userService.getAllUsers();
		for (User ur: allUsers){
			System.out.println(ur.getFirstName());
			System.out.println(ur.getLastName());
		}

	}
}
