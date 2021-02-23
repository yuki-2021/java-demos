package com.yuki.demo1.service;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    User deleteUser(User user);

    List<User> getUsers();

    User getUsersById(User user);
}
