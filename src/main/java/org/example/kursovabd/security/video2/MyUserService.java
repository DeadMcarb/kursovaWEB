package org.example.kursovabd.security.video2;


import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserService {
    private MyUserRepository ur;
    private PasswordEncoder passwordEncoder;

    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ur.save(user);
    }

}
