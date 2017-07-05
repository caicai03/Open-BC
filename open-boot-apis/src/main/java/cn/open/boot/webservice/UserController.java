package cn.open.boot.webservice;

import cn.open.boot.entity.User;
import cn.open.boot.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller
 * <p>
 * Created by qianlu on 2017/7/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        User user = new User();
        user.setUsername("15623885110");
        user.setPassword("123456");
        userManager.create(user);
        return user.getId();
    }

}
