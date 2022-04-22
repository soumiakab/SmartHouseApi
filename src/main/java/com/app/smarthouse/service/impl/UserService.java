package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.User;
import com.app.smarthouse.repository.UserRepository;
import com.app.smarthouse.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getOne(String id){
        return userRepository.findById(id).orElse(null);
    }
}
