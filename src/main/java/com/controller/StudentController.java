package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ProjectDto;
import com.dto.ProjectSelectDto;
import com.dto.StudentDto;
import com.entity.Project;
import com.entity.ProjectSelect;
import com.entity.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController extends  BaseController {
	//显示学生的信息
	@RequestMapping("/studentController/showStudent")
	public String showStudent(HttpSession session, ModelMap map) {
		StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		Student student = studentService.findById(sD.getNo());
		map.addAttribute("student", student);
		return "studentManagement/studentInfo";
	}

	//更新学生信息
	@RequestMapping("/studentController/update")
	//@RequestParam("usermail")String usermail,@RequestParam("probackground")String probackground,@RequestParam("exlearning")String exlearning,@RequestParam("researchto")String researchto
	public String update(StudentDto studentDto) {
		studentService.update(studentDto);
		return "forward:/studentController/showStudent";
	}

	//修改密码
	@RequestMapping("/studentController/updatePassword")
	public String updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("reNewPassword") String reNewPassword, Model model) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		StudentDto studentDto = (StudentDto) request.getSession().getAttribute("studentDto");
		String no = studentDto.getNo();

		System.out.print(studentDto.getPassword() + no);
		if (newPassword.equals(reNewPassword)) {
			String md5Password = DigestUtils.md5DigestAsHex(newPassword.getBytes());
			studentService.updatePassword(no, newPassword);
			return "forward:/studentController/showStudent";
		} else {
			String msg = "密码错误";
			model.addAttribute("msg", msg);
			return "studentManagement/studentInfo";

		}
	}

	//显示选择方案
	@RequestMapping("/studentController/selectProject")
	public String selectProject(HttpSession session, Model model) {
		StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		ArrayList<Project> projects = projectService.findStuProject(sD.getNo());
		List<Project> allProjects = projectService.findAllProjectByStu(sD.getNo());
		model.addAttribute("projects", projects);
		model.addAttribute("allProjects", allProjects);
        System.out.println(allProjects);
		return "studentManagement/selectProject";
	}
	//退选项目
	@RequestMapping("/deleteStuProject")
	public String deleteStuProject(Model model,@RequestParam("projectNo") String projectNo,HttpSession session){
        StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		projectService.deleProjectByProjectNo(projectNo,sD.getNo());
		return "forward:/studentController/selectProject";
	}
	//条件查询，未完成，sql问题
	@RequestMapping("/studentController/selectProjectBy")
	public String selectProjectBy(HttpSession session, Model model,@RequestParam("typeId") Integer typeId,@RequestParam("name") String name,@RequestParam("price") String price){
        StudentDto sD = (StudentDto) session.getAttribute("studentDto");
        System.out.println(sD.getNo()+"|"+name+"|"+price+"|"+typeId);
        ArrayList<Project> projects = projectService.findStuProject(sD.getNo());
        List<Project> allProjects= projectService.findAllProjectByThree(sD.getNo(),name,price,typeId);
        model.addAttribute("projects", projects);
		System.out.println(allProjects.toString());
        model.addAttribute("allProjects", allProjects);
		return "studentManagement/selectProject";
	}
    //选择项目
    @RequestMapping("/studentController/insertSelectProject")
    public String insertSelectProject(Model model,HttpServletResponse response, HttpSession session, @RequestParam("projectId")String projectId, @RequestParam("sel_reason")String sel_reason){
		StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		String company_name = projectService.findCompany_name(projectId);
		//查询是否存在
		boolean stuProjectTure = projectService.findStuProjectTure(sD.getNo(), projectId);
		//判断是否存在,是就是存在
		if (stuProjectTure==true){
			model.addAttribute("Msg","已经选择了！");
			return "forward:/studentController/selectProject";
		}else {
			System.out.print("================================================");
			projectService.insertProjectIntoSelect(sD.getNo(),projectId,sel_reason,company_name);
			return "forward:/studentController/selectProject";
		}


    }











	//方案成绩查看
	@RequestMapping("/studentController/findScore")
	public String selectScore(HttpSession session, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
		StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		ArrayList<ProjectSelectDto> list = projectService.findAllScore(sD.getNo());
		PageHelper.startPage(2, 1);
		System.out.println(list);
		PageInfo<ProjectSelectDto> pageInfo = new PageInfo<ProjectSelectDto>(list);
		model.addAttribute("pageInfo", pageInfo);
		return "studentManagement/findScore";
	}
	//方案成绩查看ByCategory
	@RequestMapping("/studentController/findScoreByCategory")
	public String selectScoreByCategory(HttpSession session, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam("typeId") Integer typeId) {
		StudentDto sD = (StudentDto) session.getAttribute("studentDto");
		ArrayList<ProjectSelectDto> list = null;
		if ("".equals(typeId) && typeId == null) {
			list = projectService.findAllScore(sD.getNo());
		} else {
			list = projectService.findScore(sD.getNo(), typeId);
		}
		PageHelper.startPage(2, 1);
		System.out.println(list);
		PageInfo<ProjectSelectDto> pageInfo = new PageInfo<ProjectSelectDto>(list);
		model.addAttribute("pageInfo", pageInfo);
		return "studentManagement/findScore";
	}
}
