package com.portail.potsfield_club.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.portail.potsfield_club.model.Role;
import com.portail.potsfield_club.model.User;
import com.portail.potsfield_club.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	User getUserById(Long id);
	void saveUser(User user);
	void deleteUserById(long id);
	void saveRole(Role role);
}
