package personal.cyy.automall.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.component.UrlComponent;
import personal.cyy.automall.contract.UploadResponse;
import personal.cyy.automall.service.FileServiceImpl;

import java.net.UnknownHostException;

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

    @Autowired
    private UrlComponent urlComponent;

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
    public UploadResponse uploadImage(@RequestParam("image") MultipartFile file) throws UnknownHostException {
        CommonResult commonResult = fileService.saveFormFile(file);
        String imageId = (String) commonResult.getData();

        UploadResponse uploadResponse = new UploadResponse();
        uploadResponse.setImageId(imageId);
        String url = urlComponent.getUrl() + "/api/file/image/" + imageId;
        log.info("uploadImage imageId: {}， url: {}", imageId, url);
        uploadResponse.setUrl(url);
        uploadResponse.setDownloadURL(url);
        return uploadResponse;
    }
}
