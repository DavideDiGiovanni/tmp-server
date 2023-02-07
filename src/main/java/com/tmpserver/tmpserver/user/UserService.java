package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        Optional<User> userOptional = userRepository.findById(email);

        if(userOptional.isPresent()) {
            throw new IllegalStateException("User with email " + email + " already exists.");
        }

        User user = new User(
                email,
                signUpRequest.getName(),
                signUpRequest.getFamilyName(),
                signUpRequest.getPassword()
        );

        userRepository.save(user);
    }

}
