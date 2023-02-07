package com.tmpserver.tmpserver.user;

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

    @GetMapping("public/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("public/signup")
    public void signUp(HttpServletRequest request,
                       @Valid @RequestBody SignUpRequest signUpRequest) {

        userService.addNewUser(signUpRequest);
    }
}
