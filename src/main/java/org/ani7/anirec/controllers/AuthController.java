package org.ani7.anirec.controllers;

import org.ani7.anirec.models.User;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.payloads.JwtAuthenticationResponse;
import org.ani7.anirec.payloads.LoginRequest;
import org.ani7.anirec.payloads.RegisterRequest;
import org.ani7.anirec.repositories.UserRepository;
import org.ani7.anirec.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtTokenProvider provider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserNameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = provider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        if (repository.existsByUserName(registerRequest.getUserName())) {
            return new ResponseEntity(new ApiResponse(false, "Username already taken!"), HttpStatus.BAD_REQUEST);
        }
        if (repository.existsByEmail(registerRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email already taken!"), HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(registerRequest.getUserName(), registerRequest.getFirstName(), registerRequest.getLastName(),
                registerRequest.getPassword(), registerRequest.getEmail(), registerRequest.getGender(),
                registerRequest.getDateOfBirth(), registerRequest.getUserType());

        user.setPassword(encoder.encode(user.getPassword()));

        User result = repository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
