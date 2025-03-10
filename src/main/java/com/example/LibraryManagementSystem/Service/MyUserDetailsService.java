package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Model.UserPrincipal;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username).orElseThrow(() ->
                new UsernameNotFoundException("UserName not found: " + username));

        return new UserPrincipal(user);
    }
}
