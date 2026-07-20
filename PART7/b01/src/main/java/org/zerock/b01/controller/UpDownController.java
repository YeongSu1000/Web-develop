package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.upload.UploadFileDto;

@RestController
@Log4j2
public class UpDownController {

    @Value("${org.zerock.upload.path}") // import 시에 springframework 으로 시작하는 value
    private String uploadPath;

    @Operation(summary = "upload Post", description = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    public String upload(@ModelAttribute UploadFileDto uploadFileDTO){

        log.info(uploadFileDTO);

        if(uploadFileDTO.getFiles() != null){

            uploadFileDTO.getFiles().forEach(multipartFile -> {

                log.info(multipartFile.getOriginalFilename());
            });
        }

        return null;
    }

}
