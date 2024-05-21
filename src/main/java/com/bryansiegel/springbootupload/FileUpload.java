package com.bryansiegel.springbootupload;

import jakarta.persistence.*;

@Entity
public class FileUpload {

    public FileUpload() {
    }

    public FileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true, length = 64)
    private String fileUpload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(String fileUpload) {
        this.fileUpload = fileUpload;
    }

    @Transient
    public String getFilePath() {
        if (fileUpload == null || id == null) return null;
        return "/user-files/" + id + "/" + fileUpload;
    }

    @Override
    public String toString() {
        return "FileUpload{" +
                "id=" + id +
                ", fileUpload='" + fileUpload + '\'' +
                '}';
    }
}
