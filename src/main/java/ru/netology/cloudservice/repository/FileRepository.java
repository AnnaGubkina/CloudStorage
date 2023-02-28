package ru.netology.cloudservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.cloudservice.entity.CloudFile;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<CloudFile, Long> {


    void deleteByUserIdAndFilename(Long userId, String filename);

    CloudFile findByUserIdAndFilename(Long userId, String filename);

    @Query(value = "select * from netology_diploma.files f where f.user_id = ?1 order by f.id desc limit ?2", nativeQuery = true)
    List<CloudFile> findAllByUserIdWithLimit(Long userId, int limit);

    @Modifying
    @Query("update CloudFile  f set f.filename = :newName where f.filename = :fileName and f.userId = :userId")
    void updateFileNameByUserId(@Param("userId")Optional<Long> userId, @Param("fileName")String oldFileName, @Param("newName")String newFileName);


}
