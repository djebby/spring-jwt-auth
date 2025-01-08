package com.djebby.auth.service;

import com.djebby.auth.model.AuthenticationRequest;
import com.djebby.auth.model.RegisterRequest;
import com.djebby.auth.model.Role;
import com.djebby.auth.model.User;
import com.djebby.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public User register(RegisterRequest request) {
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(this.bCryptPasswordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        return this.userRepository.save(user);
    }


    public String verify(AuthenticationRequest request) {
        System.out.println(request);
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("successfully authenticated");
            return this.jwtService.generateToken(request.getEmail());
        }

        return "invalid email or password";
    }
}












































