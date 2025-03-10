package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    private final JWTService jwtService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void updateUserPassword(int id, String newPassword) {
        User user = getUserById(id);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("User: " + name + " not found"));
    }

    public String verify(User user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getName());
        }
        return "fail";
    }
}
