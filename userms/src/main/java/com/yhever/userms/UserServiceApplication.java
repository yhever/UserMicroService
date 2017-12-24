package com.yhever.userms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableEurekaClient
@EnableAutoConfiguration
public class UserServiceApplication {

    @RequestMapping("/hi")
    @ResponseBody
    String home() {
        return "Hello World this is user micro service!";
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}