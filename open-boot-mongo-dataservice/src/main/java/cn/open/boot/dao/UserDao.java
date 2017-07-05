package cn.open.boot.dao;

import cn.open.boot.dataservice.mongo.AbstractDAO;
import cn.open.boot.entity.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

/**
 * Mongo user dao
 * <p>
 * Created by qianlu on 2017/7/5.
 */
public class UserDao extends AbstractDAO<User, String> {

    public UserDao(Datastore ds) {
        super(ds);
    }

    /**
     * find use by username
     *
     * @param username
     * @return
     */
    public User getByUsername(String username) {
        Query<User> q = createQuery().filter("username", username);
        return this.findOne(q);
    }

    /**
     * update user by userid
     *
     * @param user
     * @return
     */
    public UpdateResults update(User user) {
        Query<User> q = this.createQuery().filter("id", user.getId());
        UpdateOperations<User> opts = this.createUpdateOperations();
        setValue(opts, "username", user.getUsername());
        setValue(opts, "password", user.getPassword());
        setValue(opts, "realName", user.getRealName());
        setValue(opts, "sex", user.getSex());
        setValue(opts, "email", user.getEmail());
        setValue(opts, "phone", user.getPhone());
        setValue(opts, "cityCode", user.getCityCode());
        setValue(opts, "countryCode", user.getCountryCode());
        setValue(opts, "icon", user.getIcon());
        setValue(opts, "status", user.getStatus());
        setValue(opts, "roleId", user.getRoleId());
        return this.updateFirst(q, opts);
    }

}