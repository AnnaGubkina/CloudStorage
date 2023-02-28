package ru.netology.cloudservice.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.netology.cloudservice.entity.CloudFile;
import ru.netology.cloudservice.web.response.FileWebResponse;

@Component
@Mapper(componentModel = "spring")
public interface FileMapper {

    FileWebResponse cloudFileToFileWebResponse(CloudFile cloudFile);

}
