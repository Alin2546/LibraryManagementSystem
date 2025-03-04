package com.example.LibraryManagementSystem.Security;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class UserAuth implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found"));
//
//    }
//}
