package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.example.demo.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.TokenProvider;
import com.example.demo.entities.Group;
import com.example.demo.entities.Users;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.HuleResponse;
import com.example.demo.response.LoginResponse;
import com.example.demo.response.UserResponse;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.service.UserService;
import com.example.demo.utils.SecurityUtil;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        Users user = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        user.setTokenKey(jwt);
        userService.save(user);
        LoginResponse loginResponse = new LoginResponse(jwt);
        return ResponseEntity.ok(loginResponse);
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        String userName = SecurityUtil.getUserName().get();
        System.out.println("User name: " + userName);
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/group-user")
    public ResponseEntity<HuleResponse> selectGroupUser(@RequestParam("userId") Long userId) {
        List<Group> groups = userService.selectGroupByUserId(userId);
        HuleResponse response = new HuleResponse(0, groups);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user-info")
    public ResponseEntity<HuleResponse> getUserInformation() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Optional<Users> user = Optional.ofNullable(securityContext.getAuthentication())
                .map(authen -> ((CustomUserDetails) authen.getPrincipal()).getUser());
        HuleResponse response = new HuleResponse(0, new UserResponse(user.get()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<HuleResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        Users users = userService.registerNewUserAccount(registerRequest);
        HuleResponse response = new HuleResponse(0, new UserResponse(users));
        return ResponseEntity.ok(response);
    }
}
