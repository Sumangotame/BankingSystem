package com.example.suman.CRUD.service;
import com.example.suman.CRUD.model.AppUser;
import com.example.suman.CRUD.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;
    public AppUser saveUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<AppUser> getAllUser(){
    return userRepository.findAll();
    }
    public Optional<AppUser> getOneUser(Long id)
    {
      return userRepository.findById(id);
    }
}
