package personal.cyy.automall.service;

import com.google.common.collect.ArrayListMultimap;
import net.coobird.thumbnailator.Thumbnails;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.model.tmp.UploadFile;
import personal.cyy.automall.service.inter.IFileService;
import personal.cyy.automall.service.inter.IService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Cinyky
 * @Date 20:04 2019-05-16
 */

@Service
public class FileServiceImpl implements IFileService, IService {

    @Autowired
    private MongoTemplate mongoTemplate;

    private Map<String, UploadFile> id2FileMap;
    private ArrayListMultimap<String, String> car2FileMap;

    public FileServiceImpl() {
        id2FileMap = new ConcurrentHashMap<>();
        car2FileMap = ArrayListMultimap.create();
    }

    private void putIntoCache(UploadFile file) {
        id2FileMap.put(file.getId(), file);
        car2FileMap.put(file.getCarId(), file.getId());
    }

    private UploadFile getFromCache(String fileId) {
        if (id2FileMap.containsKey(fileId)) {
            return id2FileMap.get(fileId);
        }
        return null;
    }

    private void removeFromCache(String fileId) {
        if (id2FileMap.containsKey(fileId)) {
            id2FileMap.remove(fileId);
        }

    }

    /**
     * 保存文件
     *
     * @param file
     */
    @Override
    public UploadFile saveFile(UploadFile file) {
        UploadFile savedFile = mongoTemplate.save(file);
        putIntoCache(savedFile);
        return savedFile;
    }

    /**
     * 保存表单文件
     *
     * @param file
     */
    @Override
    public CommonResult saveFormFile(MultipartFile file) {
        CommonResult commonResult;
        if (file.isEmpty()) {
            commonResult = CommonResult.failed("请选择一张照片");
        } else {
            try {
                BufferedImage bufferedImage = Thumbnails.of(file.getInputStream()).scale(0.3F).outputQuality(0.3F).asBufferedImage();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                //png 为要保存的图片格式
                ImageIO.write(bufferedImage, "png", out);
                // 返回的 JSON 对象，这种类可自己封装
                String fileName = file.getOriginalFilename();
                UploadFile uploadFile = new UploadFile();
                uploadFile.setName(fileName);
                uploadFile.setCreatedTime(new Date());
                uploadFile.setContent(new Binary(out.toByteArray()));
                uploadFile.setContentType(file.getContentType());
                uploadFile.setSize(out.toByteArray().length);

                UploadFile savedFile = saveFile(uploadFile);
                String url = savedFile.getId();
                commonResult = CommonResult.success(url, "图片上传成功");
            } catch (Exception e) {
                e.printStackTrace();
                commonResult = CommonResult.failed("图片上传失败");
            }
        }
        return commonResult;
    }

    /**
     * 获取文件
     *
     * @param fileId
     * @return
     */
    @Override
    public UploadFile getFile(String fileId) {
        UploadFile file = getFromCache(fileId);
        if (file == null) {
            file = mongoTemplate.findById(fileId, UploadFile.class);
            if (file != null) {
                putIntoCache(file);
            }
        }
        return file;
    }

    /**
     * 获取文件数据
     *
     * @param fileId
     * @return
     */
    @Override
    public byte[] getFileData(String fileId) {
        UploadFile file = getFile(fileId);
        if (file != null) {
            return file.getContent().getData();
        }
        return new byte[0];
    }

    /**
     * @param carId
     * @return
     */
    @Override
    public List<String> getFileUrls(String carId) {
        return car2FileMap.get(carId);
    }

    /**
     * 删除所有的图片
     *
     * @param carId
     */
    @Override
    public void delete(String carId) {
        List<String> fileUrls = getFileUrls(carId);
        fileUrls.stream().forEach(
                fileUrl -> mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(fileUrl)), UploadFile.class)
        );
    }

    @Override
    public void init() {
        List<UploadFile> uploadFiles = mongoTemplate.findAll(UploadFile.class);
        uploadFiles.stream().forEach(
                uploadFile -> {
                    putIntoCache(uploadFile);
                }
        );
    }
}
