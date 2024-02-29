package com.questionpro.grocerybooking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.questionpro.grocerybooking.models.MyUserDetails;
import com.questionpro.grocerybooking.models.User;
import com.questionpro.grocerybooking.repos.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("NOT FOUND "+userName));
		//UserDetails usd = new MyUserDetails(user.get());
		return user.map(MyUserDetails::new).get();
	}
	


}
