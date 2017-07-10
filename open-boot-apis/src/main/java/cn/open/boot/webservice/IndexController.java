package cn.open.boot.webservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * api index page
 * <p>
 * Created by lenovo on 2017/7/1.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;


    @RequestMapping("/")
    public String index() {
        return "Open boot api v1.0.0";
    }

    @RequestMapping("/info")
    public String info() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Open boot api v1.0.0";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-A, Result is " + r;
    }
}