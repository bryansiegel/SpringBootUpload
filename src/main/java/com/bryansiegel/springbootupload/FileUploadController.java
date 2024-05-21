package com.bryansiegel.springbootupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class FileUploadController {

    @Autowired
private FileUploadRepo fileUploadRepository;

    public FileUploadController(FileUploadRepo fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("files/save")
    public String saveFile() {
        return "fileUpload";
    }

    @PostMapping("/files/save")
    public RedirectView saveUser(FileUpload _fileupload,
                                 @RequestParam("file") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        _fileupload.setFileUpload(fileName);

        FileUpload savedUser = fileUploadRepository.save(_fileupload);

        String uploadDir = "user-files/" + savedUser.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/", true);

    }
}
