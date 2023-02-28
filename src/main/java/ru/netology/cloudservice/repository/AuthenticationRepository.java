package ru.netology.cloudservice.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
token storage
 */


@Repository
public class AuthenticationRepository {

    private final Map<String, String> tokens = new ConcurrentHashMap<>();


    public void putTokenAndUsername(String token, String username) {
        tokens.put(token, username);
    }

    public String getUserNameByToken(String token) {
        return tokens.get(token);
    }

    public void removeTokenAndUsernameByToken(String token) {
        tokens.remove(token);
    }
}
