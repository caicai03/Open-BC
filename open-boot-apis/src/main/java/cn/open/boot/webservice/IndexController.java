package cn.open.boot.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @RequestMapping("/info")
    public String info() {
        System.out.println("Time : " + new Date());
        return "Open boot api v1.0.0";
    }
}