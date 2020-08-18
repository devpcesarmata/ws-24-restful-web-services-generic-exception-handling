/**
 * 
 */
package com.cesarmata.ws24restfulwebservicesgenericexceptionhandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cesarmata.ws24restfulwebservicesgenericexceptionhandling.dto.User;

/**
 * @author Cesar Mata.
 *
 */
@Component
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "César", new Date()));
		users.add(new User(2, "Mata", new Date()));
		users.add(new User(3, "Sánchez", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		users.add(user);
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}