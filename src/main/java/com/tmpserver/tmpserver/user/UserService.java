package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.request.SignInRequest;
import com.tmpserver.tmpserver.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> studentList;

    public UserService() {
        studentList = List.of(
            new User(
                    "davide.digiovanni@sysconsgroup.com",
                    "Davide",
                    "Di Giovanni",
                    "password12"
            ),
            new User(
                    "marco.baratto@sysconsgroup.com",
                    "Marco",
                    "Baratto",
                    "password34"
            )
        );
    }

    public List<User> getUsers() {
        return studentList;
    }

    public void addNewUser(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        Optional<User> userOptional = this.findByEmail(email);

        if(userOptional.isPresent()) {
            throw new IllegalStateException("User with email " + email + " already exists.");
        }

        User user = new User(
                email,
                signUpRequest.getName(),
                signUpRequest.getFamilyName(),
                signUpRequest.getPassword()
        );

        studentList.add(user);
    }

    public User getUser(SignInRequest signInRequest) {
        String email = signInRequest.getEmail();
        Optional<User> userOptional = this.findByEmail(email);

        if(userOptional.isEmpty()) {
            throw  new IllegalStateException("User with email " + email + " does not exist.");
        }

        User user = userOptional.get();

        if(!user.getPassword().equals(signInRequest.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }

        return user;
    }

    private Optional<User> findByEmail(String email) {
        return studentList.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }
}
