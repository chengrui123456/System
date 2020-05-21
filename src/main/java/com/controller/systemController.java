package com.controller;


import com.dao.CompanyMapper;
import com.dao.SystemParameterMapper;
import com.dto.CompanyDto;
import com.dto.StudentDto;
import com.dto.SystemParameterDto;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class systemController extends BaseController {
    @Autowired
    SystemParameterMapper systemParameterMapper;
    @Autowired
    CompanyMapper companyMapper;

    @RequestMapping("/showSystem")
    public String showStudent(HttpSession session) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String userName = (String) session.getAttribute("account");
        SystemParameterDto system = systemParameterService.findSystem(userName);
        attribute.getRequest().getSession().setAttribute("system",system);
        return "systemsManagement/systemsInfo";
    }
    //更新管理员信息
    @RequestMapping("/updateSystemsInfo")
    public  String  updateSystemsInfo(SystemParameterDto systemParameterDto){
        systemParameterService.updateSystem(systemParameterDto);
        return "redirect:/showSystem";
    }
    //展示学生
    @RequestMapping("/systemsStudents")
    public  String  systemsStudents(Model model){

        List<StudentDto> list = studentService.findAll();
        model.addAttribute("students", list);
        return "systemsManagement/systemsStudents";
    }
    //删除学生
    @RequestMapping("/deleteStudentss")
    public  String  deleteStudent(@RequestParam("studentNo")String studentNo,ModelMap map){
        studentService.delete(studentNo);
        System.out.println(studentNo+"-------");
        List<StudentDto> students = studentService.findAll();
        map.addAttribute("students",students);
        return "redirect:/systemsStudents";
    }
    //增加学生
    @RequestMapping("/insertStudent")
    public  String  insertStudent(StudentDto studentDto,Model map){
        studentService.insert(studentDto);
        List<StudentDto> students = studentService.findAll();
        map.addAttribute("students",students);
        return "redirect:/systemsStudents";
    }
    //查看公司
    @RequestMapping("/systemsCompanies")
    public  String  systemsCompanies(Model model){

        List<CompanyDto> list = companyService.findAllCompany();

        model.addAttribute("company", list);
        return "systemsManagement/systemsCompanies";
    }
    //删除公司
    @RequestMapping("/deleteCompany")
    public  String  deleteCompany(@RequestParam("cno")String company_name,Model map){
        companyService.deleteCompany(company_name);
        List<CompanyDto> company = companyService.findAllCompany();
        map.addAttribute("company",company);
        return "redirect:/systemsCompanies";
    }
    //查找公司
    @RequestMapping("/findCompanyByName")
    public  String  findCompanyByName(@RequestParam("price")String company_name,Model map){
        List<CompanyDto> companyByName = companyService.findCompanyByName(company_name);
        map.addAttribute("company",companyByName);
        return "systemsManagement/systemsCompanies";
    }


    //第三部分
    @RequestMapping("/systemsCompanyNotice")
    public String allProjectList(Company company, Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String account=(String) request.getSession().getAttribute("account");

        PageHelper.startPage(pageNum,5);
        List<Company> list = systemParameterService.findAllCompany();
        PageInfo<Company> pageInfo = new PageInfo<Company>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/systemsCompanyNotice";
    }


    @RequestMapping("/companyNoticeDetail")
    public String companyNoticeDetail( @RequestParam("cno") String cno
            ) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        attribute.getRequest().getSession().setAttribute("cno",cno);
        return "redirect:/companyNoticeDetails";

    }

    @RequestMapping("/companyNoticeDetails")
    public String companyNoticeDetails(Project project, Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {

        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String cno=(String) request.getSession().getAttribute("cno");

        PageHelper.startPage(pageNum, 5);
        List<Project> list = systemParameterService.fineNoticeList(cno);
        PageInfo<Project> pageInfo = new PageInfo<Project>(list);
        model.addAttribute("Company", cno);

        model.addAttribute("pageInfo", pageInfo);

        return "systemsManagement/companyNoticeDetails";

    }

    @RequestMapping("/updateBySS")
    public String updateBySS(Project project, Model model, @RequestParam("nId") String nId
            , @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String cno=(String) request.getSession().getAttribute("cn");

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        project.setNo(nId);
        project.setCompany_username(cno);
        project.setAudit_date(sqlDate);
        systemParameterService.updateBySs(project);



        return "redirect:/companyNoticeDetails";

    }

    @RequestMapping("/deleteBySS")
    public String deleteBySS( @RequestParam("nId") String nId ) {

        systemParameterService.deleteBySS(nId);

        return "redirect:/companyNoticeDetails";

    }


    @RequestMapping("/systemsCNFindbysome")
    public String systemsCNFindbysome(Company company,@RequestParam("company_name")String company_name,Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
    ) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String cno=(String) request.getSession().getAttribute("cno");

        PageHelper.startPage(pageNum,5);
        List<Company> list = systemParameterService.findCompanyBysome(company_name);
        PageInfo<Company> pageInfo = new PageInfo<Company>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/systemsCompanyNotice";
    }




    @RequestMapping("/systemsNoticeInfo")
    public String systemsNoticeInfo(NoticeAdmin noticeAdmin, Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {


        PageHelper.startPage(pageNum,5);
        List<NoticeAdmin> list = systemParameterService.findAllNoticeAdmin();
        PageInfo<NoticeAdmin> pageInfo = new PageInfo<NoticeAdmin>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/systemsNoticeInfo";
    }


    @RequestMapping("/deleteNoticeBySS")
    public String deleteNoticeBySS(NoticeAdmin noticeAdmin,@RequestParam("adNId")Integer adNId) {

        systemParameterService.deleteNoticeBySS(adNId);

        return "redirect:/systemsNoticeInfo";
    }

    @RequestMapping("/adminAddNotice")
    public String adminAddNotice(NoticeAdmin noticeAdmin,@RequestParam("notitle")String notitle,@RequestParam("nocontent")String nocontent) {

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        noticeAdmin.setRelease_date(sqlDate);
        noticeAdmin.setTitle(notitle);
        noticeAdmin.setContent(nocontent);
        systemParameterService.insortNoticeAdmin(noticeAdmin);
        return "redirect:/systemsNoticeInfo";
    }


    //项目审核
    @RequestMapping("/auditProjects")
    public String auditProjects(Project project, Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {


        PageHelper.startPage(pageNum,5);
        List<Project> list = systemParameterService.findAllProject();
        PageInfo<Project> pageInfo = new PageInfo<Project>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/auditProject";
    }



    //审核
    @RequestMapping("/updateProjectBySS")
    public String updateProjectBySS(Project project, Model model, @RequestParam("pno") String nId
            , @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String cno=(String) request.getSession().getAttribute("cn");

        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        project.setNo(nId);
        project.setCompany_username(cno);
        project.setAudit_date(sqlDate);
        systemParameterService.updateBySs(project);



        return "redirect:/auditProjects";

    }

    //退审
    @RequestMapping("/updateAuditBySS")
    public String updateAuditBySS( @RequestParam("pno") String pno ) {

        systemParameterService.updateAudit(pno);

        return "redirect:/auditProjects";

    }

    //查寻
    @RequestMapping("/findProjectSome")
    public String findProjectSome(@RequestParam("name")String name,Project project,Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
    ) {


        project.setName(name);

        PageHelper.startPage(pageNum,5);
        List<Project> list = systemParameterService.findByname(project);
        PageInfo<Project> pageInfo = new PageInfo<Project>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/auditProject";
    }

    //学生选课管理
    @RequestMapping("/systemsProjectInfos")
    public String systemsProjectInfos(ProjectSelect projectSelect, Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {


        PageHelper.startPage(pageNum,5);
        List<ProjectSelect> list = systemParameterService.findAllProjectSelect();
        PageInfo<ProjectSelect> pageInfo = new PageInfo<ProjectSelect>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "systemsManagement/systemsProjectInfo";
    }

    //查寻
//    @RequestMapping("/findProjectSelectSomes")
//    public String findProjectSelectSomes(Student student,@RequestParam("classs")String classs, @RequestParam("grade")Integer grade, ProjectSelect projectSelect, Model model , @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
//    ) {
//
//
//        student.setClasss(classs);
//        student.setGrade(grade);
//       // String studentNo=systemParameterService.findStudentNo(student);
////        PageHelper.startPage(pageNum,5);
////        List<Project> list = systemParameterService.findByname(project);
////        PageInfo<Project> pageInfo = new PageInfo<Project>(list);
////        model.addAttribute("pageInfo",pageInfo);
////        return "systemsManagement/auditProject";
//    }

    @RequestMapping("/ExitServlet")
    public String ExitServlet(HttpServletRequest request, HttpServletResponse response ) {
        HttpSession session = request.getSession(false);//防止创建Session
        session.removeAttribute("account");
        return "/index";
    }
}
