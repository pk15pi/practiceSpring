package com.example.firstspring.services;
import com.example.firstspring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstspring.repositories.UserRepo;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> getUserByMobile(Long mobile){
        return userRepo.findAllByMobile(mobile);
    }

    public List<User> getUserByEmailAndMobile(String email, Long mobile) {
        return userRepo.findByEmailAndMobile(email, mobile);
    }
}
