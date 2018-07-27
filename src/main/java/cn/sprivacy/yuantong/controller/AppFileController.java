package cn.sprivacy.yuantong.controller;

import cn.sprivacy.yuantong.util.AppResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cailun
 * @date 2018年 07月27日
 */
@RestController
@RequestMapping("/file")
public class AppFileController {
    @GetMapping("/upload-template")
    public void getUploadTemplate() {

    }
    @PostMapping("/upload")
    public AppResponse upload(MultipartFile file) {
        return null;
    }
}
