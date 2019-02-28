package com.lambdaschool.ourcourses.repository;

import com.lambdaschool.ourcourses.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
