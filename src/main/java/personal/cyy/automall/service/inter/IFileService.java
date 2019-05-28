package personal.cyy.automall.service.inter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.model.tmp.UploadFile;

import java.util.List;

/**
 * 文件服务类
 *
 * @Author Cinyky
 * @Date 20:00 2019-05-16
 */

@Service
public interface IFileService {
    /**
     * 保存文件
     *
     * @param file
     */
    UploadFile saveFile(UploadFile file);

    /**
     * 保存表单文件
     *
     * @param file
     */
    CommonResult saveFormFile(MultipartFile file);

    /**
     * 获取文件
     *
     * @param fileId
     * @return
     */
    UploadFile getFile(String fileId);

    /**
     * 获取文件数据
     *
     * @param fileId
     * @return
     */
    byte[] getFileData(String fileId);

    /**
     * @param carId
     * @return
     */
    List<String> getFileUrls(String carId);

    /**
     * 删除所有的图片
     *
     * @param carId
     */
    void delete(String carId);
}
