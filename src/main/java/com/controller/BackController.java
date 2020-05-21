package com.controller;


import com.dto.CompanyDto;
import com.dto.NoticeCompanyDto;
import com.dto.ProjectDto;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class BackController extends BaseController{

       @RequestMapping("/company/logout")
       public String logout() {
           ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
           attributes.getRequest().getSession().removeAttribute("companyDto");
           return "login/login";
       }

	   @PostMapping("/company/register")
	   @ResponseBody
	   public String addArticle(@RequestParam("companyName")String companyName,@RequestParam("userName")String userName,@RequestParam("companypPassword")String companypPassword,@RequestParam("mailbox")String mailbox,@RequestParam("vscode")String vscode,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		   SystemParameter systemParameter=new SystemParameter();
		   systemParameter=companyService.systemparameter(vscode);
		     CompanyDto companyDto=new CompanyDto();
		     companyDto.setUsername(userName);
		     companyDto.setPassword(companypPassword);
		     companyDto.setMailbox(mailbox);
		     companyDto.setCompanyName(companyName);
		   if(systemParameter.getAdmin_username()!=null){
			companyService.registerCompanyInfo(companyDto);		   
		    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"../login/login.html");  
		   }else {
			   httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"../login/login.html");
		}return null; 
	   }
	  
       
	   @RequestMapping("/company/findall")
       public List<CompanyDto> findall() {      
           return companyService.listAllCompanys();
       }
	   
	   
	   @RequestMapping("/company/deleteById")
       public String deleteById(@RequestParam("username")String username) {
		   companyService.deleteCompanyByUsername(username);	   
		return null;      
          
       }
	   
	   @RequestMapping("/index")
       public ModelAndView listNoticeCompany(ModelAndView model) {
		   List<NoticeCompanyDto> noticeCompanyDto=new ArrayList<NoticeCompanyDto>();
		   noticeCompanyDto=companyService.listAllNotice();
		   model.addObject("companyNotices", noticeCompanyDto);
		   model.setViewName("index");
		return model;
          
       }

	@RequestMapping("/ListCompanyInfo")
	public String ListCompanyInfo() {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
       	String account=(String) request.getSession().getAttribute("account");
		Company company=new Company();
		company=companyService.listByUserName(account);
		CompanyDto companyDto=new CompanyDto();
		companyDto.setUsername(company.getUsername());
		companyDto.setPassword(company.getPassword());
		companyDto.setCompanyName(company.getCompany_name());
		companyDto.setMailbox(company.getMailbox());
		companyDto.setAddress(company.getAddress());
		companyDto.setAuditDate(company.getAudit_date());
		companyDto.setContacts(company.getContacts());
		companyDto.setProfile(company.getProfile());
		companyDto.setPhone(company.getPhone());

		attribute.getRequest().getSession().setAttribute("com", companyDto); //将登陆用户信息存入到session域对象中

		return "companyManagement/companyInfo";


	}

	@RequestMapping("/UpdateCompanyInfo")
	public String UpdateCompanyInfo(@RequestParam("profile")String profile,@RequestParam("username")String username,@RequestParam("userid")String userid,@RequestParam("usermail")String usermail,
								  @RequestParam("usercontacts")String usercontacts,@RequestParam("userphone")String userphone,@RequestParam("useraddress")String useraddress
								  ) {

		CompanyDto companyDto=new CompanyDto();
		companyDto.setUsername(userid);
		companyDto.setCompanyName(username);
		companyDto.setPhone(userphone);
		companyDto.setMailbox(usermail);
		companyDto.setContacts(usercontacts);
		companyDto.setAddress(useraddress);
        companyDto.setProfile(profile);
		companyService.updateCompanyInfo(companyDto);


		return "redirect:/ListCompanyInfo";


	}

    @RequestMapping("/resetpassword")
	public  String resetpassword( @RequestParam("oldPassword")String oldPassword,@RequestParam("newPassword")String newPassword,Model model){
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		CompanyDto companyDto=(CompanyDto) request.getSession().getAttribute("com");
		String account=(String) request.getSession().getAttribute("account");

        System.out.print(companyDto.getPassword()+account);
		if(companyDto.getPassword().equals(oldPassword)) {
			String md5Password = DigestUtils.md5DigestAsHex(newPassword.getBytes());
			companyService.updateCompanyPassword(account, newPassword);

			return "redirect:/ListCompanyInfo";
		}else {
			String msg="密码错误";
			model.addAttribute("msg",msg);
			return "companyManagement/companyInfo";

		}

	}


	@RequestMapping("/insertProject")
	public String UpdateCompanyInfo(@RequestParam("name")String name,@RequestParam("studentNum")Integer studentNum,
									@RequestParam("companyTeacher")String companyTeacher,@RequestParam("companyTeacherTitle")String companyTeacherTitle,
									@RequestParam("major")String major,@RequestParam("instruction")String instruction,
									@RequestParam("category")String category,@RequestParam("grade")Integer grade,Integer m) {

		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       	HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");

		m = Calendar.getInstance().get(Calendar.YEAR);
        String a=companyService.getProjectNo(m);

        grade=2013+grade;
		ProjectDto projectDto=new ProjectDto();
		projectDto.setNo(a);
		projectDto.setName(name);
		projectDto.setStudentsNum(studentNum);
		projectDto.setCompanyTeacher(companyTeacher);
		projectDto.setCompanyTeacherTitle(companyTeacherTitle);
		projectDto.setMajor(major);
		projectDto.setIntroduction(instruction);
	    projectDto.setCategory(category);
	    projectDto.setGrade(grade);
	    projectDto.setCompanyUsername(account);
		companyService.insertProject(projectDto);


		return "companyManagement/releaseProject";
	}






    @RequestMapping("/allProjectList")
    public String allProjectList(Project project,Model model,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String account=(String) request.getSession().getAttribute("account");
		PageHelper.startPage(pageNum,5);
		List<Project> list = companyService.selectByUsernameAndPage(account);
		PageInfo<Project> pageInfo = new PageInfo<Project>(list);
		model.addAttribute("pageInfo",pageInfo);
        return "companyManagement/projectInfo";
    }


    @RequestMapping("/findProjectBySome")
	public String findProjectBySome(@RequestParam("No")String No,@RequestParam("name")String name,
									@RequestParam("grade")Integer grade,Project project,Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
									) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");
		project.setNo(No);
		project.setName(name);
		project.setGrade(grade);
		project.setCompany_username(account);
		PageHelper.startPage(pageNum,5);
		List<Project> list = companyService.findByProjectSome(project);
		PageInfo<Project> pageInfo = new PageInfo<Project>(list);
		model.addAttribute("pageInfo",pageInfo);
		return "companyManagement/projectInfo";
	}

	@RequestMapping("/NoaduitProjectList")
	public String NoaduitProjectList(Project project,Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");
		project.setCompany_username(account);
		PageHelper.startPage(pageNum,5);
		List<Project> list = companyService.findByNoaduitProjectList(project);
		PageInfo<Project> pageInfo = new PageInfo<Project>(list);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("key","1");
		return "companyManagement/projectInfo";
	}


	@RequestMapping("/exitLogin")
	public String exitLogin(HttpServletRequest request, HttpServletResponse response ) {
		HttpSession session = request.getSession(false);//防止创建Session
		session.removeAttribute("account");
		return "/index";
	}


	@RequestMapping("/deleteProject")
	public String deleteProject(Map<String,Object> model, @RequestParam("No")String No ) {
		companyService.deleteByExample(No);
		model.put("msg","删除成功");
		return "redirect:/allProjectList";
	}


	@RequestMapping("/updateProjectl")
	public String updateProjectl( @RequestParam("No")String No ) {
       	Project project=new Project();
		project=companyService.ListByNo(No);
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		attribute.getRequest().getSession().setAttribute("uppro",project);
		return "companyManagement/updateProject";
	}

	@RequestMapping("/updateProject")
	public String updateProject( @RequestParam("pno")String pno,@RequestParam("name")String name,@RequestParam("studentNum")Integer studentNum,
								 @RequestParam("companyTeacher")String companyTeacher,@RequestParam("companyTeacherTitle")String companyTeacherTitle,
								 @RequestParam("major")String major,@RequestParam("instruction")String instruction,
								 @RequestParam("category")String category,@RequestParam("grade")Integer grade	) {
		ProjectDto projectDto=new ProjectDto();
		projectDto.setNo(pno);
		projectDto.setName(name);
		projectDto.setStudentsNum(studentNum);
		projectDto.setCompanyTeacher(companyTeacher);
		projectDto.setCompanyTeacherTitle(companyTeacherTitle);
		projectDto.setMajor(major);
		projectDto.setIntroduction(instruction);
		projectDto.setCategory(category);
		projectDto.setGrade(grade);
		companyService.updateProject(projectDto);

		return "redirect:/allProjectList";
	}
//学生成绩全部信息
	@RequestMapping("/allStudentList")
	public String allStudentList(Project project, ProjectSelect projectSelect,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");


		PageHelper.startPage(pageNum,5);
		List<ProjectSelect> list = companyService.findByProjectSelect(account);
		PageInfo<ProjectSelect> pageInfo = new PageInfo<ProjectSelect>(list);
		model.addAttribute("pageInfo",pageInfo);
		return "companyManagement/projectScore";
	}

//学生推选条件查询
	@RequestMapping("/projectScoreFSome")
	public String projectScoreFSome(ProjectSelect projectSelect,@RequestParam("projectNo")String projectNo,Model model ,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
	) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");

		projectSelect.setCompany_name(account);
		projectSelect.setProjectNo(projectNo);

		PageHelper.startPage(pageNum,5);
		List<ProjectSelect> list = companyService.findByProjectScoreSome(projectSelect);

		PageInfo<ProjectSelect> pageInfo = new PageInfo<ProjectSelect>(list);
		model.addAttribute("pageInfo",pageInfo);
		return "companyManagement/projectScore";
	}
//企业打分session
	@RequestMapping("/updateProjectS")
	public String updateProjectS(ProjectSelect projectSelect, @RequestParam("StudentNo")String StudentNo) {

		projectSelect=companyService.findCompanySelect(StudentNo);
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		attribute.getRequest().getSession().setAttribute("pns",projectSelect);
		return "companyManagement/getScore";
	}
	//企业打分
	@RequestMapping("/GetScoreServlet")
	public String GetScoreServlet(ProjectSelect projectSelect, @RequestParam("psno")String psno , @RequestParam("ppno")String ppno
			   , @RequestParam("score")String score) {
       	projectSelect.setStudentNo(psno);
		projectSelect.setProjectNo(ppno);
		projectSelect.setScore(score);
		companyService.UpdateCompnaySelects(projectSelect);
		return "redirect:/allStudentList";
	}

	//企业退选学生选课
	@RequestMapping("/deleteProjectSelects")
	public String deleteProjectSelects(ProjectSelect projectSelect, @RequestParam("No")String StudentNo) {

		companyService.deleteProjectSelects(StudentNo);
		return "redirect:/allStudentList";
	}


//发布公告
	@RequestMapping("/AddNoticeCompany")
	public String AddNoticeCompany(NoticeCompany noticeCompany,@RequestParam("notitle")String notitle,@RequestParam("nocontent")String nocontent) {

		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");

		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		noticeCompany.setRelease_date(sqlDate);
		noticeCompany.setCompany_username(account);
		noticeCompany.setTitle(notitle);
		noticeCompany.setContent(nocontent);

		companyService.insortNoticeCompany(noticeCompany);


		return "companyManagement/releaseNotice";
	}

//公告维护
	@RequestMapping("/companyNoticeInfo")
	public String companyNoticeInfo(NoticeCompany noticeCompany, ProjectSelect projectSelect,Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");
		PageHelper.startPage(pageNum,5);
		List<NoticeCompany> list = companyService.findNoticeCompany(account);
		PageInfo<NoticeCompany> pageInfo = new PageInfo<NoticeCompany>(list);
		model.addAttribute("pageInfo",pageInfo);
		return "companyManagement/companyNoticeInfo";
	}

	//公告维护修改公告
	@RequestMapping("/updateNoticeProjectl")
	public String updateNoticeProjectl(NoticeCompany noticeCompany, @RequestParam("No")Integer ID ) {
		noticeCompany=companyService.findNoticeCompanyById(ID);
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		attribute.getRequest().getSession().setAttribute("cn",noticeCompany);
		return "companyManagement/updateNotice";
	}

//修改公告
	@RequestMapping("/UpdateCompanyNotice")
	public String UpdateCompanyNotice(NoticeCompany noticeCompany, @RequestParam("id")Integer ID,@RequestParam("notitle")String notitle,
									  @RequestParam("nocontent")String nocontent) {
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attribute.getRequest();
		String account=(String) request.getSession().getAttribute("account");


		noticeCompany.setID(ID);
		noticeCompany.setTitle(notitle);
		noticeCompany.setContent(nocontent);
		noticeCompany.setCompany_username(account);

		companyService.updateNoticeCompany(noticeCompany);

		return "redirect:/companyNoticeInfo";
	}
}
