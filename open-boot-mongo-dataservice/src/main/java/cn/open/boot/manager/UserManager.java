package cn.open.boot.manager;

import cn.open.boot.dao.UserDao;
import cn.open.boot.entity.User;
import cn.open.boot.utils.Identities;
import cn.open.boot.web.StandardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Mongo user manager
 * <p>
 * Created by qianlu on 2017/7/5.
 */
@Service
public class UserManager extends StandardManager<User, String> {

    @Autowired
    private UserDao userDao;

    @Override
    public void delete(String id) {
        userDao.deleteById(id);
    }

    @Override
    public void create(User user) {
        if (user != null) {
            user.setId(Identities.uuid2());
            user.setCreateDate(new Date());
            userDao.save(user);
        }
    }

    @Override
    public void update(User user) {
        if (user != null) {
            userDao.update(user);
        }
    }

    @Override
    public User get(String id) {
        return userDao.get(id);
    }
}
