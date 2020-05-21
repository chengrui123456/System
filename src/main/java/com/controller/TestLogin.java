package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestLogin {

    @RequestMapping("/menu")
    public String menu(){
        return "studentManagement/menu";
    }
    @RequestMapping("/homePage")
    public String homePage(){
        return "studentManagement/homePage";
    }

    @RequestMapping("/top")
    public String top(){
        return "studentManagement/top";
    }
    @RequestMapping("/rest")
    public String rest(){
        return "studentManagement/rest";
    }
}
