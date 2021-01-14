package com.ushwamala.thymeleaf.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
public class DemoController {

    @GetMapping(value ="/hello")
    String sayHello(Model theModel){

        theModel.addAttribute("date", new java.util.Date());
        return "hello";
    }
}
