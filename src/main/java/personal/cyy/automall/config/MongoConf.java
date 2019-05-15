package personal.cyy.automall.config;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

/**
 * @Author Cinyky
 * @Date 13:54 2019-05-15
 */


@Configuration
public class MongoConf {
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private GridFSBucket gridFSBucket;


    @Bean
    public GridFSBucket getGridFSBuckets() {
        MongoDatabase db = mongoDbFactory.getDb();
        return GridFSBuckets.create(db);
    }
}