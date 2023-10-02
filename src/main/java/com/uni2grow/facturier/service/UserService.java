package com.uni2grow.facturier.service;


import com.uni2grow.facturier.model.User;
import com.uni2grow.facturier.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public Iterable<User>getUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
