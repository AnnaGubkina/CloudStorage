package ru.netology.cloudservice.web.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class FileNameEditRequest {

    @NotBlank(message = "login must not be null")
    private String filename;


}
