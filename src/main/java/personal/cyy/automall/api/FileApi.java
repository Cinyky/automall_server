package personal.cyy.automall.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.service.FileServiceImpl;

/**
 * File API
 * @Author Cinyky
 * @Date 15:24 2019-05-15
 */

@RestController
@RequestMapping("/api/file")
@Slf4j
public class FileApi {
    @Autowired
    private FileServiceImpl fileService;

    /**
     * 获取图片
     *
     * @param fileId
     * @return
     */
    @GetMapping(value = "/image/{fileId}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String fileId) {
        byte[] fileData = fileService.getFileData(fileId);
        return fileData;
    }

    /**
     * 获取图片
     *
     * @return
     */
    @PostMapping(value = "/image/upload")
    @ResponseBody
    public CommonResult uploadImage(@RequestParam("image") MultipartFile file) {
        CommonResult commonResult = fileService.saveFormFile(file);
        String imageId = (String) commonResult.getData();
        log.info("imageId: {}", imageId);
        return commonResult;
    }
}
