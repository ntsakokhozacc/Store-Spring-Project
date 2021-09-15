package com.example.SecondProjecdemo.Service;

import com.example.SecondProjecdemo.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long Id);
    void deleteUserById(long Id);
}
