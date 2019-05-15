package personal.cyy.automall.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.cyy.automall.model.tmp.UploadFile;

/**
 * @Author Cinyky
 * @Date 15:24 2019-05-15
 */

@Controller
@RequestMapping("/api/file")
public class FileApi {
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String id) {
        byte[] data = null;
        UploadFile image = mongoTemplate.findById(id, UploadFile.class);
        if (image != null) {
            data = image.getContent().getData();
        }
        return data;
    }
}
