package com.bryansiegel.springbootupload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepo extends JpaRepository<FileUpload, Long> {
}
