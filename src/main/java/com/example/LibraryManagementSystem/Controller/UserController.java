package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Model.User;
import com.example.LibraryManagementSystem.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UsersService usersService;

    @GetMapping("/findAll")
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return usersService.getUserById(id);
    }

    @GetMapping("/find")
    public User fingUserByName(@RequestParam String name) {
        return usersService.findByName(name);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return usersService.saveUser(user);
    }

    @PutMapping("updateUserPassword/{id}")
    public void updateUserPassword(@PathVariable int id, @RequestParam String newPassword) {
        usersService.updateUserPassword(id, newPassword);
    }

    @PostMapping("/login")
    public String login (@RequestBody User user){
        return usersService.verify(user);
    }

}
