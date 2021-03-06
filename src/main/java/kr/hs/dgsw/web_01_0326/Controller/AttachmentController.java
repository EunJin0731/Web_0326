package kr.hs.dgsw.web_01_0326.Controller;

import kr.hs.dgsw.web_01_0326.Protocol.AttachmentProtocol;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class AttachmentController {

    @PostMapping("/attachment")
    public AttachmentProtocol upload(@RequestPart MultipartFile srcfile) {
        String destFilename
                = "C:/Users/JEJ/IdeaProjects/web_01_0326/upload/"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/"))
                + UUID.randomUUID().toString() + "_"
                + srcfile.getOriginalFilename();
        try {
            File destFile = new File(destFilename);
            destFile.getParentFile().mkdirs();
            srcfile.transferTo(destFile);
            return new AttachmentProtocol(destFilename, srcfile.getOriginalFilename());
        } catch (Exception ex) {
            return null;
        }
    }
}
