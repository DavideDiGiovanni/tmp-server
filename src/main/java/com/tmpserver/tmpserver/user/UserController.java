package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.request.SignInRequest;
import com.tmpserver.tmpserver.request.SignUpRequest;
import com.tmpserver.tmpserver.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getusers")
    public ResponseEntity<ApiResponse> getUsers(HttpServletRequest request) {
        ApiResponse response = userService.getUsers();
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("signup")
    public ResponseEntity<ApiResponse> signUp(HttpServletRequest request,
                       @Valid @RequestBody SignUpRequest signUpRequest) {

        ApiResponse response = userService.addNewUser(signUpRequest);
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("signin")
    public ResponseEntity<ApiResponse> signIn(HttpServletRequest request,
                     @Valid @RequestBody SignInRequest signInRequest) {

        ApiResponse response = userService.getUser(signInRequest);
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, response.getStatus());
    }

}
