package com.stone.accounting.controller;

import com.stone.accounting.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author stone
 * @date 2022/11/14-@16:55
 *
 * @RestController相当于加了@Controller、@ResponseBody两个注解
 *
 */
@RestController
public class HelloController {

    //获得自增int值
    private AtomicInteger atomicInteger =new AtomicInteger();

    @RequestMapping("/hello/{name}")
    public User sayHello(@PathVariable("name") String name){
        System.out.println(name);

        return new User(atomicInteger.incrementAndGet(),name);
    }
}
