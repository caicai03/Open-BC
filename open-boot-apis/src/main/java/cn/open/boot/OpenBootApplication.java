package cn.open.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * boot start
 * <p>
 * Created by qianlu on 2017/7/1.
 */
@SpringBootApplication
@ImportResource({"classpath:*.xml"})
public class OpenBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenBootApplication.class, args);
    }

}
