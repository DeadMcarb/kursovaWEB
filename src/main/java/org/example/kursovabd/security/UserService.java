package org.example.kursovabd.security;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository ur;
    private PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ur.save(user);
    }
    public Optional<User> findByName(String name) {
        return ur.findByName(name);
    };

    public List<User> getUsers() {
        return ur.findAll();
    }

    public Optional<User> findById(int id) {
        return ur.findById(id);
    }

}
