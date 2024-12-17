package org.example.kursovabd.servises;

import lombok.AllArgsConstructor;
import org.example.kursovabd.data.*;
import org.example.kursovabd.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(String userName, String password, String roles, String email) {
        userRepository.save(new User(userName, password, roles, email));
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByName(String name ) {
        return userRepository.findByName(name);
    }


    public void updateUser(int UserId, String UserName) {
        Optional<User> User = userRepository.findById(UserId);
        User.ifPresent(a->{
            a.setName(UserName);
            userRepository.save(a);
        });
    }
}