package ru.prokhorov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prokhorov.entities.User;
import ru.prokhorov.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserById(long user_id){
        return userRepository.findById(user_id);
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }
}
