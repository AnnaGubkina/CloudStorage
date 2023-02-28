package ru.netology.cloudservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.entity.Role;
import ru.netology.cloudservice.entity.User;
import ru.netology.cloudservice.exception.InputDataException;
import ru.netology.cloudservice.model.EnumRoles;
import ru.netology.cloudservice.repository.AuthenticationRepository;
import ru.netology.cloudservice.repository.UserRepository;
import ru.netology.cloudservice.security.JwtTokenUtil;
import ru.netology.cloudservice.web.request.AuthRequest;
import ru.netology.cloudservice.web.response.AuthResponse;

import java.util.Collections;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationRepository authenticationRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    //здесь мы регистрируем нового пользователя и сохраняем его в базу, если такая функция будет необходима
    public ResponseEntity<?> register(AuthRequest request) {
        Optional<User> userFromBD = userRepository.findByUsername(request.getLogin());
        if (userFromBD.isPresent()) {
            throw new InputDataException("User with the same username already exists");
        }

        User newUser = User.builder()
                .username(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(new Role(EnumRoles.ROLE_USER)))
                .build();
        userRepository.save(newUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    public AuthResponse login(AuthRequest request) {
        final String username = request.getLogin();
        final String password = request.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        final UserDetails userDetails = userService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        authenticationRepository.putTokenAndUsername(token, username);
        log.info("User {} is authorized", username);
        return AuthResponse.builder()
                .authToken(token)
                .build();
    }


    public void logout(String authToken) {
        if (authToken.startsWith("Bearer ")) {
            authToken = authToken.substring(7);
        }
        final String username = authenticationRepository.getUserNameByToken(authToken);
        log.info("User {} logout", username);
        authenticationRepository.removeTokenAndUsernameByToken(authToken);
    }
}
