package com.eduardobarrera.todoapp.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.eduardobarrera.todoapp.entity.UserRole;
import com.eduardobarrera.todoapp.repository.UserRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		com.eduardobarrera.todoapp.entity.User user = userRepository.findByUsername(userName);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	private User buildUser(com.eduardobarrera.todoapp.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole){
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(	UserRole uRole: userRole) {
			auths.add(new SimpleGrantedAuthority(uRole.getRole()));
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}
	
	
}
