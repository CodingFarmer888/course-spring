package com.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.model.User;

@Service
public class UserService {

	public List<User> queryAllUsers() {
		List<User> users = new ArrayList<>();
		User kitty = new User();
		kitty.setId(1L);
		kitty.setName("凱蒂貓");
		kitty.setAge(5);
		kitty.setHobbies(Arrays.asList("吃飯", "睡覺", "打東東"));
		users.add(kitty);
		
		User snoopy = new User();
		snoopy.setId(2L);
		snoopy.setName("史奴比");
		snoopy.setAge(10);
		snoopy.setHobbies(Arrays.asList("吃飯", "睡覺", "打東東"));
		users.add(snoopy);
		return users;
	}

	public User findUserById(Long id) {
		List<User> users = queryAllUsers();
		return users.stream().filter(u -> id.equals(u.getId())).findFirst().orElse(null);
	}
}
