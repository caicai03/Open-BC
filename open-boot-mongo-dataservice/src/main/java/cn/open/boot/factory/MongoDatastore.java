package cn.open.boot.factory;

import cn.open.boot.dataservice.mongo.DatastoreFactory;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/7/14.
 */
@Component
public class MongoDatastore extends DatastoreFactory {

    @Override
    @Value("${mongo.db}")
    public void setDbName(String dbName) {
        super.setDbName(dbName);
    }

    @Override
    @Autowired
    public void setMongoClient(MongoClient mongoClient) {
        super.setMongoClient(mongoClient);
    }
}
