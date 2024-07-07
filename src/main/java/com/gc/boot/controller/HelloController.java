package com.gc.boot.controller;

import com.gc.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
- @RestController该注解为一个组合注解，相当于@Controller和@ResponseBody的组合
- @ResponseBody：支持将返回值放到response内，而不是一个页面，通常用户返回json数据。
- @Component、@Controller、@Service、@Repository：实例化bean,定义Spring管理的组件。它表明一个类会作为组件类，并告诉Spring要为这个类创建bean
 */
@RestController
@Slf4j
public class HelloController {
  @Autowired
  Car car;
  @RequestMapping("/car2")
  public Car getCar(){
    return car;
  }
  @RequestMapping("/")
  public String home(){
    log.info("xxxxxsss");
    return "helloworld" + "你好 ";
  }
}
