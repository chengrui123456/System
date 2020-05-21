package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentDto;
import com.dto.SystemParameterDto;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dto.CompanyDto;

@Controller
@RequestMapping("/Login")
public class LoginController extends BaseController{
	 @RequestMapping("login")
	   public String login(@RequestParam("userName")String userName,@RequestParam("role")String role,@RequestParam("code")String code,@RequestParam("imageHidden")String imageHidden, @RequestParam("password") String password,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception {

		 ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		 attributes.getRequest().getSession().setAttribute("role", role); //将登陆用户信息存入到session域对象中
		 switch (role) {
			 case "1":
				 CompanyDto companyDto = new CompanyDto();
				 companyDto = companyService.Login(userName);
				 if (companyDto.getUsername().equals(userName) && companyDto.getPassword().equals(password) && imageHidden.equals(code)) {
					 ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					 attribute.getRequest().getSession().setAttribute("account", userName); //将登陆用户信息存入到session域对象中
					 return "companyManagement/index";
				 } else {
					 return "redirect:/loginHtml";
				 }
			 case "2":
				 StudentDto studentDto = new StudentDto();
				 studentDto=studentService.Login(userName);
				 if(studentDto.getNo().equals(userName)&&studentDto.getPassword().equals(password)&&imageHidden.equals(code)) {
					 ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					 attribute.getRequest().getSession().setAttribute("studentDto", studentDto);
					 attribute.getRequest().getSession().setAttribute("account", userName); //将登陆用户信息存入到session域对象中
					 return "studentManagement/index";
				 }
				 else {
					 return "redirect:/loginHtml";
				 }
			 case "9":
				 SystemParameterDto systemParameterDto = new SystemParameterDto();
				 systemParameterDto = systemParameterService.Login(userName);
				 if (systemParameterDto.getAdminUsername().equals(userName) && systemParameterDto.getAdminPassword().equals(password) && imageHidden.equals(code)) {
					 ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
					 attribute.getRequest().getSession().setAttribute("account", userName); //将登陆用户信息存入到session域对象中
					 return "SystemsManagement/index";
				 }
				 else {
					 return "redirect:/loginHtml";
				 }

		 }


		 return "login/login";
	 }
}
