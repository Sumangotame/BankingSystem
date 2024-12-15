package com.example.suman.CRUD.service;
import com.example.suman.CRUD.model.User;
import com.example.suman.CRUD.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    public User saveUser(User appUser) {
        return userRepository.save(appUser);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUser(){
    return userRepository.findAll();
    }
    public Optional<User> getOneUser(Long id)
    {
      return userRepository.findById(id);
    }
}
