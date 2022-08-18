package com.pluralsight.pluralsightdemo.services;

import com.pluralsight.pluralsightdemo.models.User;
import com.pluralsight.pluralsightdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("The username was not found"));
        return user.map(MyUserDetails::new).get();
    }
}
