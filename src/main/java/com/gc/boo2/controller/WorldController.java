package com.gc.boo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
  @RequestMapping("/root2")
  public String home(){
    return "world";
  }
}
