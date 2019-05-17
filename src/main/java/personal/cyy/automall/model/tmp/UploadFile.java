package personal.cyy.automall.model.tmp;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import personal.cyy.automall.model.AbstractModel;

import java.util.Date;


/**
 * 存储车图片
 *
 * @Author Cinyky
 * @Date 16:41 2019-05-10
 */

@Data
@Document
public class UploadFile extends AbstractModel {

    /**
     * 图片ID
     */
    @Id
    private String id;


    /**
     * 汽车ID
     */
    private String carId;

    /**
     * 文件名
     */
    private String name;


    /**
     * 文件内容
     */
    private Binary content;

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 文件大小
     */
    private long size;

    /**
     * 上传时间
     */
    private Date createdTime;


}
