package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    final private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void updateUserPassword(int id, String newPassword) {
        User user = getUserById(id);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

}
