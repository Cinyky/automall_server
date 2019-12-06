package personal.cyy.automall.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.cyy.automall.service.FileServiceImpl;

/**
 * File API
 * @Author Cinyky
 * @Date 15:24 2019-05-15
 */

@Controller
@RequestMapping("/api/file")
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
}
