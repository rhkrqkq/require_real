package org.example.require.service;

import lombok.RequiredArgsConstructor;
import org.example.require.domain.User;
import org.example.require.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public void signup(String email, String name, String password) {
        User user = new User(email, name, password);

        userRepository.save(user);
    }
}
