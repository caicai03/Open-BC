package cn.open.boot.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api index page
 * <p>
 * Created by lenovo on 2017/7/1.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Open boot api v1.0.0";
    }

}