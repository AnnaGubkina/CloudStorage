package ru.netology.cloudservice.web.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
public class AuthRequest {

    @NotBlank(message = "login must not be null")
    private String login;

    @NotBlank(message = "password must not be null")
    @Size(min = 2,max = 30, message = "Password should be between 2 and 30 characters")
    private String password;


}
