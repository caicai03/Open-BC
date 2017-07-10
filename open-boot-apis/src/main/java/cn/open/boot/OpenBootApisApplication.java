package cn.open.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * apis start
 * <p>
 * Created by qianlu on 2017/7/1.
 */
@EnableDiscoveryClient
@SpringBootApplication
@ImportResource({"classpath:*.xml"})
public class OpenBootApisApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OpenBootApisApplication.class).web(true).run(args);
    }

}
