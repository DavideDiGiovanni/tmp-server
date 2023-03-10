package com.tmpserver.tmpserver.user;

import com.tmpserver.tmpserver.google.GoogleService;
import com.tmpserver.tmpserver.google.SignInGoogleRequest;
import com.tmpserver.tmpserver.request.SignInRequest;
import com.tmpserver.tmpserver.request.SignUpRequest;
import com.tmpserver.tmpserver.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    public static final HttpStatus OK = HttpStatus.OK;
    private final UserService userService;
    private final GoogleService googleService;

    @Autowired
    public UserController(UserService userService, GoogleService googleService) {
        this.userService = userService;
        this.googleService = googleService;
    }

    @GetMapping("getusers")
    public ResponseEntity<ApiResponse> getUsers(HttpServletRequest request) {
        List<User> userList = userService.getUsers();
        ApiResponse response = new ApiResponse(OK, request);
        response.setMessage(userList);

        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("signingoogle")
    public ResponseEntity<ApiResponse> signInGoogle(HttpServletRequest request,
                                                    @Valid @RequestBody SignInGoogleRequest signInGoogleRequest) {
        String token = signInGoogleRequest.getJwt();

        ApiResponse response = new ApiResponse(OK, request);
        response.setMessage(googleService.getUser(token));

        return new ResponseEntity<>(response, OK);
    }

    @PostMapping("signup")
    public ResponseEntity<ApiResponse> signUp(HttpServletRequest request,
                       @Valid @RequestBody SignUpRequest signUpRequest) {

        userService.addNewUser(signUpRequest);
        ApiResponse response = new ApiResponse(OK, request);
        response.setMessage("User with " + signUpRequest.getEmail() + " registered.");

        return new ResponseEntity<>(response, OK);
    }

    @GetMapping("signin")
    public ResponseEntity<ApiResponse> signIn(HttpServletRequest request,
                     @Valid @RequestBody SignInRequest signInRequest) {

        User user = userService.getUser(signInRequest);
        ApiResponse response = new ApiResponse(OK, request);
        response.setMessage(user);

        return new ResponseEntity<>(response, OK);
    }

}
