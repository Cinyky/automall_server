package personal.cyy.automall.mongo;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

/**
 * @Author Cinyky
 * @Date 13:55 2019-05-15
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbGridFsTest {
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Test
    public void delete() throws Exception {
        gridFsTemplate.delete(query(where("_id").is("5cdbaed66cd79f0b2c3e0237")));
    }

    @Test
    public void getFile() throws Exception {
        GridFSFile file = gridFsTemplate.findOne(query(whereFilename().is("avatar.png")));
        if (file != null) {
            System.out.println("_id:" + file.getId());
            System.out.println("_objectId:" + file.getObjectId());
            GridFSDownloadStream in = gridFSBucket.openDownloadStream(file.getObjectId());

            GridFsResource resource = new GridFsResource(file, in);
            InputStream inputStream = resource.getInputStream();
            byte[] f = getBytes(inputStream);


            FileOutputStream out = new FileOutputStream("/Users/cyy/Desktop/avatar_copy.png");
            out.write(f);
        }

    }

    private byte[] getBytes(InputStream inputStream) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int i = 0;
        while (-1 != (i = inputStream.read(b))) {
            bos.write(b, 0, i);
        }
        return bos.toByteArray();
    }

    @Test
    public void storeFile() throws Exception {
        org.springframework.core.io.Resource resource = new FileSystemResource("/Users/cyy/Desktop/avatar.png");
        ObjectId id = gridFsTemplate.store(resource.getInputStream(), resource.getFilename(), ".png");
        System.out.println("_id:" + id);
    }
}