package ru.netology.cloudservice.web.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileWebResponse {

    private String filename;
    private Integer size;

}
