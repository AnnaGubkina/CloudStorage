package ru.netology.cloudservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files" ,schema = "netology_diploma")
public class CloudFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column
    private String type;

    @Lob
    @Column(nullable = false)
    private byte[] fileData;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private Long userId;

    public CloudFile(String fileName, LocalDateTime now, String contentType, byte[] bytes, long size, Long id) {
        this.filename = fileName;
        this.date = now;
        this.type = contentType;
        this.fileData = bytes;
        this.size = size;
        this.userId = id;
    }
}
