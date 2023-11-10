package com.escola.backend.service;

import java.util.List;
import java.util.Optional;

import com.escola.backend.model.Users;

public interface UserService {

    List<Users> findAll();

    Users findByEmail(String user_email);

    Users save(Users User);

    int deleteByEmail(String user_email);

}