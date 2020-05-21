package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/**
 * 重定向
 *
 */
public class RedirectController {

    @RequestMapping("/loginHtml")
     public String loginHtml(){

        return "login/login";
     }

     @RequestMapping("/menuHtml")
    public String menuHtml(){
        return "companyManagement/menu";
     }

    @RequestMapping("/homePageHtml")
    public String homePageHtml(){
        return "companyManagement/homePage";
    }

    @RequestMapping("/topHtml")
    public String topHtml(){
        return "companyManagement/top";
    }

    @RequestMapping("/restHtml")
    public String restHtml(){
        return "companyManagement/rest";
    }

    @RequestMapping("/indexHtml")
    public String indexHtml(){

        return "index";
    }

    @RequestMapping("/userHtml")
    public String companyHtml(@RequestParam("role")String role){

        switch (role) {
            case "1":
            return "companyManagement/index";
            case "2":
                return "student/index";
            case "9":
                return "systemsManagement/index";
        }
        return null;
    }


    @RequestMapping("/projectInfoHtml")
    public String projectInfoHtml(){

        return "companyManagement/projectInfo";
    }

    @RequestMapping("/projectScoreHtml")
    public String projectScoreHtml(){

        return "companyManagement/projectScore";
    }

    @RequestMapping("/companyNoticeInfoHtml")
    public String companyNoticeInfoHtml(){

        return "companyManagement/companyNoticeInfo";
    }

    @RequestMapping("/releaseProjectHtml")
    public String releaseProjectHtml(){

        return "companyManagement/releaseProject";
    }

    @RequestMapping("/stopHtml")
    public String stopHtml(){

        return "systemsManagement/top";
    }

    @RequestMapping("/releaseNoticeHtml")
    public String releaseNoticeHtml(){

        return "companyManagement/releaseNotice";
    }


    @RequestMapping("/srestHtml")
    public String srestHtml(){

        return "systemsManagement/rest";
    }

    @RequestMapping("/smenuHtml")
    public String smenuHtml(){

        return "systemsManagement/menu";
    }

    @RequestMapping("/shomepageHtml")
    public String shomepageHtml(){

        return "systemsManagement/homepage";
    }

    @RequestMapping("/indextml")
    public String indextml(){

        return "index";
    }

    @RequestMapping("/adminAddNoticeHtml")
    public String adminAddNoticeHtml(){

        return "systemsManagement/adminAddNotice";
    }

    @RequestMapping("/insertStudentss")
    public String insertStudent(){
        return "systemsManagement/insertStudent";
    }
}
