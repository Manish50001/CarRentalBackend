package com.code_with_man.car.rental.services.jwt;

import com.code_with_man.car.rental.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetailsService userDetailsService() {
		return username -> userRepository.findFirstByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
	}

}
