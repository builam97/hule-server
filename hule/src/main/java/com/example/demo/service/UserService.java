package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entities.Role;
import com.example.demo.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Group;
import com.example.demo.entities.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CustomUserDetails;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
    
    public UserDetails loadUserById(Long userId) {
        Optional<Users> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(user.get().getUserName());
        }
        return new CustomUserDetails(user.get());
    }
    
    public Users save(Users user) {
       return userRepository.save(user);
    }

    public String getUserName(String token) {
        return userRepository.findByToken(token);
    }
    
    public List<Group> selectGroupByUserId(Long userId) {
        return userRepository.selectGroupByUserId(userId);
    }

    public Users registerNewUserAccount(RegisterRequest registerRequest) {
        Users user = new Users();
        user.setUserName(registerRequest.getUserName());

        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        user.setEmail(registerRequest.getEmail());
        user.setRoles(Set.of(new Role(Long.valueOf(1), "user")));
        return userRepository.save(user);
    }
}
