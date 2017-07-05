package cn.open.boot.dataservice.mongo;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.UpdateOperations;


/**
 * Mongo db basic abstract dao
 * Created by qianlu on 2017/7/1.
 *
 * @param <T>
 * @param <K>
 */
public abstract class AbstractDAO<T, K> extends BasicDAO<T, K> {

    protected AbstractDAO(Datastore ds) {
        super(ds);
    }

    public AbstractDAO(Class<T> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    protected AbstractDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
    }

    public AbstractDAO(Class<T> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
        super(entityClass, mongoClient, morphia, dbName);
    }


    /**
     * mongo update operations init
     *
     * @param opts
     * @param field
     * @param value
     */
    public void setValue(UpdateOperations<T> opts, String field, Object value) {
        if (value != null) {
            opts.set(field, value);
        } else {
            opts.unset(field);
        }
    }
}