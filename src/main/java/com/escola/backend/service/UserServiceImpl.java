package com.escola.backend.service;

import com.escola.backend.model.Users;
import org.springframework.stereotype.Service;

import com.escola.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public List<Users> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public Users findByEmail(String user_email) {
        return UserRepository.findByEmail(user_email);
    }

    @Override
    public Users save(Users User) {
        return UserRepository.save(User);
    }

    @Override
    public int deleteByEmail(String user_email) {
        return UserRepository.deleteByEmail(user_email);
    }

}