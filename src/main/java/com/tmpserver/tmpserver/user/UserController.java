package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.request.SignInRequest;
import com.tmpserver.tmpserver.request.SignUpRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getusers")
    public List<User> getUsers() {
        System.out.println("get users");
        return userService.getUsers();
    }

    @PostMapping("signup")
    public void signUp(HttpServletRequest request,
                       @Valid @RequestBody SignUpRequest signUpRequest) {

        userService.addNewUser(signUpRequest);
    }

    @GetMapping("signin)")
    public User signIn(HttpServletRequest request,
                       @Valid @RequestBody SignInRequest signInRequest) {

        System.out.println("signin");

        return userService.getUser(signInRequest);
    }
}
