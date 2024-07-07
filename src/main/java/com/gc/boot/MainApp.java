package com.gc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
- 改变扫描路径，@SpringBootApplication(scanBasePackages="com.atguigu"),一般不用配
- SpringBootApplication也是一个复合注解,相当于下面三个
  @SpringBootConfiguration
  @EnableAutoConfiguration
  @ComponentScan
- @SpringBootApplication//这是一个SpringBoot应用,主程序类;主配置类

 */

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.gc.boot")
//@SpringBootApplication(scanBasePackages = "com.gc")
@SpringBootApplication//这是一个SpringBoot应用
public class MainApp {
  public static void main(String[] args) {
    //1、返回IOC容器
    ConfigurableApplicationContext run = SpringApplication.run(MainApp.class, args);
    //2、挨个遍历：
    // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
    // SpringBoot把以前配置的核心组件现在都给我们自动配置好了。
    String[] beanDefinitionNames = run.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      //System.out.println(beanDefinitionName);
    }
    //3、从容器中获取组件

    String[] beanNamesForType = run.getBeanNamesForType(DispatcherServlet.class);
    System.out.println(beanNamesForType.length);
    String[] mvc = run.getBeanNamesForType(WebMvcProperties.class);
    System.out.println("WebMvcProperties->>>>"+mvc.length);

    //Pet tomcat01 = run.getBean("tomcat01", Pet.class);
    //System.out.println(tomcat01);
    //Myconf bean = run.getBean(Myconf.class);
    //System.out.println(bean);

    //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
    //保持组件单实例
    //User user = bean.user01();
    //User user1 = bean.user01();
    //System.out.println(user == user1);


    //User user01 = run.getBean("user01", User.class);
    //Pet tom = run.getBean("tomcat01", Pet.class);
    //System.out.println("用户的宠物：" + (user01.getPet() == tom));

    // 4.获取组件
    //EvaluatorFilter filter1 = run.getBean(EvaluatorFilter.class);
    //System.out.println(filter1);
    //String[] types = run.getBeanNamesForType(User.class);
    //for (String type : types) {
    //  System.out.println(type);
    //}
    //EvaluatorFilter bean = run.getBean(EvaluatorFilter.class);
    //System.out.println(bean);

    //看看容器中有没有tom组件
    boolean b = run.containsBean("tom2");
    System.out.println(b);
    boolean b1 = run.containsBean("user01");
    System.out.println(b1);
    boolean b2 = run.containsBean("car1");
    System.out.println(b2);
  }
}
