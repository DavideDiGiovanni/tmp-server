package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.mock.UserRepositoryMocked;
import com.tmpserver.tmpserver.request.SignInRequest;
import com.tmpserver.tmpserver.request.SignUpRequest;
import com.tmpserver.tmpserver.response.ApiResponse;
import com.tmpserver.tmpserver.response.ApiResponseCorrect;
import com.tmpserver.tmpserver.response.ApiResponseError;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepositoryMocked userRepository;

    public UserService() {
        userRepository = new UserRepositoryMocked();
    }

    public ApiResponse getUsers() {
        return new ApiResponseCorrect(userRepository.findAll());
    }

    public ApiResponse addNewUser(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        Optional<User> userOptional = userRepository.findById(email);

        if(userOptional.isPresent()) {
            return new ApiResponseError(
                    new IllegalStateException("User with email " + email + " already exists.")
            );
        }

        User user = new User(
                email,
                signUpRequest.getName(),
                signUpRequest.getFamilyName(),
                signUpRequest.getPassword()
        );

        userRepository.save(user);

        return new ApiResponseCorrect(
                "User with email " + email + " saved."
        );
    }

    public ApiResponse getUser(SignInRequest signInRequest) {
        String email = signInRequest.getEmail();
        Optional<User> userOptional = userRepository.findById(email);

        if(userOptional.isEmpty()) {
            return new ApiResponseError(
                    new IllegalStateException("User with email " + email + " does not exist.")
            );
        }

        User user = userOptional.get();

        if(!user.getPassword().equals(signInRequest.getPassword())) {
            return new ApiResponseError(
                    new IllegalArgumentException("Wrong password")
            );
        }

        return new ApiResponseCorrect(
                user
        );
    }
}
