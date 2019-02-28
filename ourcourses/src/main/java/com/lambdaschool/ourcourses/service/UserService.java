package com.lambdaschool.ourcourses.service;

import com.lambdaschool.ourcourses.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}