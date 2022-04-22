package com.app.smarthouse.service.interfaces;

import com.app.smarthouse.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User addUser(User user);

    User getOne(String id);
}
