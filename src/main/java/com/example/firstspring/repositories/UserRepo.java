package com.example.firstspring.repositories;

import com.example.firstspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Custom queries
    List<User> findByEmail(String email);
    List<User> findAllByMobile(Long mobile);

    List<User> findByEmailAndMobile(String email, Long mobile);
}
