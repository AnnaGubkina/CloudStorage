package ru.netology.cloudservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.entity.User;
import ru.netology.cloudservice.repository.UserRepository;

import static java.lang.String.format;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
        User userDetails = userRepository.findByUsername(username).orElseThrow(
                () ->
                        new UsernameNotFoundException(
                                format("User with username - %s, not found", username)));;
        return userDetails;
    }

}
