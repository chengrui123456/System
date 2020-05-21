package com.service.impl;

import com.dao.*;
import com.dto.CompanyDto;
import com.dto.NoticeCompanyDto;
import com.dto.ProjectDto;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyMapper companyMapper;
	@Autowired
	SystemParameterMapper systemParameterMapper;
	@Autowired
	NoticeCompanyMapper noticeCompanyMapper;
	@Autowired
	ProjectMapper projectMapper;
	@Autowired
	ProjectSelectMapper projectSelectMapper;

	
//	 private static byte MAX_LASTEST_ARTICLE_COUNT = 5;
	//注册公司信息 
	@Override
	public  void registerCompanyInfo(CompanyDto companyDto) {
		Company company=new Company();		
		company.setAddress(companyDto.getAddress());
		company.setAudit_date(companyDto.getAuditDate());
		company.setCompany_name(companyDto.getCompanyName());
		company.setContacts(companyDto.getContacts());
		company.setMailbox(companyDto.getMailbox());
		company.setPassword(companyDto.getPassword());
		company.setPhone(companyDto.getPhone());
		company.setProfile(companyDto.getProfile());
		company.setUsername(companyDto.getUsername());
		companyMapper.insertSelective(company);
		
		
	}
//更改公司信息
	@Override
	public void updateCompanyInfo(CompanyDto companyDto) {
		Company company=new Company();
		company.setAddress(companyDto.getAddress());
		company.setAudit_date(companyDto.getAuditDate());
		company.setCompany_name(companyDto.getCompanyName());
		company.setContacts(companyDto.getContacts());
		company.setMailbox(companyDto.getMailbox());
		company.setPassword(companyDto.getPassword());
		company.setPhone(companyDto.getPhone());
		company.setProfile(companyDto.getProfile());
		company.setUsername(companyDto.getUsername());
		companyMapper.updateByPrimaryKeySelective(company);
		
	}


	@Override
	public void updateNoticeCompany(NoticeCompany noticeCompany) {
		noticeCompanyMapper.updateByPrimaryKeySelective(noticeCompany);

	}

	@Override
	public NoticeCompany findNoticeCompanyById(Integer id) {

		return noticeCompanyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<NoticeCompany> findNoticeCompany(String company_username) {
		NoticeCompanyExample example=new NoticeCompanyExample();
		NoticeCompanyExample.Criteria criteria=example.createCriteria();
		criteria.andCompany_usernameEqualTo(company_username);
		List<NoticeCompany>  noticeCompanies=noticeCompanyMapper.selectByExample(example);
		return noticeCompanies;
	}

	@Override
	public void insortNoticeCompany(NoticeCompany noticeCompany) {
		noticeCompanyMapper.insertSelective(noticeCompany);
	}

	@Override
	public List<Project> findByNoaduitProjectList(Project project) {
		List<Project>  projects=projectMapper.findByNoaduitProjectList(project);
		return projects;
	}

	@Override
	public List<Project> findByProjectSome(Project project) {
		List<Project>  projects=projectMapper.findByPage(project);
		return projects;
	}

	@Override
	public void deleteProjectSelects(String no) {
		projectSelectMapper.deleteProjectSelectss(no);
	}

	@Override
	public void UpdateCompnaySelects(ProjectSelect projectSelect) {
		projectSelectMapper.updateByPrimaryKeySelective(projectSelect);

	}

	@Override
	public ProjectSelect findCompanySelect(String no) {

		return projectSelectMapper.findProjectScoreById(no);
	}

	@Override
	public List<ProjectSelect> findByProjectScoreSome(ProjectSelect projectSelect) {
		List<ProjectSelect> projectSelects=projectSelectMapper.findProjectScoreSome(projectSelect);
		return projectSelects;
	}

	@Override
	public List<ProjectSelect> findByProjectSelect(String company_username) {

		List<ProjectSelect>  projectSelects=projectSelectMapper.findProjectScore(company_username);
		return projectSelects;

	}


	@Override
	public void updateProject(ProjectDto projectDto) {
		Project project=new Project();
		project.setNo(projectDto.getNo());
		project.setName(projectDto.getName());
		project.setStudents_num(projectDto.getStudentsNum());
		project.setCompany_teacher(projectDto.getCompanyTeacher());
		project.setCompany_teacher_title(projectDto.getCompanyTeacherTitle());
		project.setMajor(projectDto.getMajor());
		project.setIntroduction(projectDto.getIntroduction());
		project.setCategory(projectDto.getCategory());
		project.setGrade(projectDto.getGrade());
		projectMapper.updateByPrimaryKeySelective(project);
	}

	@Override
	public Project ListByNo(String No) {

		return projectMapper.selectByPrimaryKey(No);
	}

	@Override
	public Void deleteByExample(String No) {

		projectMapper.deleteByPrimaryKey(No);
        return null;
	}

	@Override
	public String getProjectNo(Integer m) {


			String a= m + "000001";
			while (projectMapper.selectByPrimaryKey(a)!=null){
				int s=Integer.parseInt(a);
				a=s + 1 + "";
			}
//
		return a;
	}



	//发布方案
	@Override
	public void insertProject(ProjectDto projectDto) {
		Project project=new Project();
		project.setNo(projectDto.getNo());
		project.setName(projectDto.getName());
		project.setStudents_num(projectDto.getStudentsNum());
		project.setCompany_teacher(projectDto.getCompanyTeacher());
		project.setCompany_teacher_title(projectDto.getCompanyTeacherTitle());
		project.setMajor(projectDto.getMajor());
		project.setIntroduction(projectDto.getIntroduction());
		project.setCategory(projectDto.getCategory());
		project.setGrade(projectDto.getGrade());
		project.setCompany_username(projectDto.getCompanyUsername());
		projectMapper.insertSelective(project);

	}

//修改密码
	@Override
	public void updateCompanyPassword(String companyUserName, String newPassword) {
		Company company=new Company();
		company.setUsername(companyUserName);
		company.setPassword(newPassword);
		companyMapper.updateByPrimaryKeySelective(company);
		
	}

//查询全部公司信息
	@Override
	public List<CompanyDto> listAllCompanys() {
		CompanyExample example=new CompanyExample();
		example.getOrderByClause();
		example.setDistinct(false);
		List<Company> companies=companyMapper.selectByExample(example);
		List<CompanyDto> articles=new ArrayList<>();
		for(Company company:companies) {
			CompanyDto companyDto=new CompanyDto();
			companyDto.setUsername(company.getUsername());
			companyDto.setAddress(company.getAddress());
			companyDto.setAuditDate(company.getAudit_date());
			companyDto.setCompanyName(company.getCompany_name());
			companyDto.setContacts(company.getContacts());
			companyDto.setMailbox(company.getMailbox());
			companyDto.setPassword(company.getPassword());
			companyDto.setPhone(company.getPhone());
			companyDto.setProfile(company.getProfile());
			articles.add(companyDto);			
		}
		
		return articles;
	}
//删除公司信息
	@Override
	public void deleteCompanyByUsername(String companyUsername) {
		CompanyDto companyDto=new CompanyDto();
		companyDto.setUsername(companyUsername);
		companyMapper.deleteByPrimaryKey(companyDto.getUsername());
		
	}
   //修改注册时间。
	@Override
	public void checkCompany(CompanyDto companyDto) {
		Company company=new Company();	
		company.setAudit_date(companyDto.getAuditDate());		
		company.setUsername(companyDto.getUsername());
		companyMapper.updateByPrimaryKeySelective(company);
		
	}
   //根据用户名查询
	@Override
	public Company listByUserName(String username) {
		return companyMapper.selectByPrimaryKey(username);
		
	}
	@Override
	public CompanyDto Login(String username) {
		Company company=new Company();
		CompanyDto companyDto=new CompanyDto();
		company=companyMapper.selectByPrimaryKey(username);
		companyDto.setUsername(company.getUsername());
		companyDto.setPassword(company.getPassword());
		return companyDto;
	}
	@Override
	public SystemParameter systemparameter(String vscode) {
		SystemParameterExample example = new SystemParameterExample();
		example.or().andInvitation_codeEqualTo(vscode);
		List<SystemParameter> systemParameterDto=systemParameterMapper.selectByExample(example);
		return systemParameterDto.get(0);
	}
	
	@Override
	public List<NoticeCompanyDto> listAllNotice(){
		NoticeCompanyExample example=new NoticeCompanyExample();
		example.getOrderByClause();
		example.setDistinct(false);
		List<NoticeCompany> companies=noticeCompanyMapper.selectByExample(example);
		List<NoticeCompanyDto> articles=new ArrayList<>();
		for(NoticeCompany noticeCompany:companies) {
			NoticeCompanyDto noticeCompanyDto=new NoticeCompanyDto();
			noticeCompanyDto.setId(noticeCompany.getID());
			noticeCompanyDto.setCompanyUsername(noticeCompany.getCompany_username());
			noticeCompanyDto.setAuditDate(noticeCompany.getAudit_date());
			noticeCompanyDto.setReleaseDate(noticeCompany.getRelease_date());
			noticeCompanyDto.setContent(noticeCompany.getContent());
			noticeCompanyDto.setTitle(noticeCompany.getTitle());
			articles.add(noticeCompanyDto);			
		}
		
		return articles;
		
	}
	
	@Override
	public List<NoticeCompany> findAllNoticeCompanyByPage() {
		NoticeCompanyExample example=new NoticeCompanyExample();
		List<NoticeCompany> noticeCompanie=noticeCompanyMapper.selectByExample(example);		

		
		return noticeCompanie;
	}

	@Override
	public List<Project> selectByUsernameAndPage( String username) {
		ProjectExample example=new ProjectExample();
		ProjectExample.Criteria criteria=example.createCriteria();
		criteria.andCompany_usernameEqualTo(username);
		List<Project>  projects=projectMapper.selectByExample(example);
		return projects;
	}



	@Override
	public List<CompanyDto> findAllCompany() {
		List<CompanyDto> companyDtos = new ArrayList<>();
		List<Company> allCompany = companyMapper.findAllCompany();
		for (Company company : allCompany) {
			CompanyDto companyDto = new CompanyDto();
			companyDto.setUsername(company.getUsername());
			companyDto.setCompanyName(company.getCompany_name());
			companyDto.setContacts(company.getContacts());
			companyDto.setMailbox(company.getMailbox());
			companyDto.setPhone(company.getPhone());
			companyDto.setAddress(company.getAddress());
			companyDtos.add(companyDto);
		}
		return companyDtos;
	}

	@Override
	public void deleteCompany(String company_name) {
		companyMapper.deleteByPrimaryKey(company_name);
	}

	@Override
	public List<CompanyDto> findCompanyByName(String company_name) {
		List<CompanyDto> companyDtos = new ArrayList<>();
		List<Company> allCompany = companyMapper.findCompanyByName(company_name);
		for (Company company : allCompany) {
			CompanyDto companyDto = new CompanyDto();
			companyDto.setUsername(company.getUsername());
			companyDto.setCompanyName(company.getCompany_name());
			companyDto.setContacts(company.getContacts());
			companyDto.setMailbox(company.getMailbox());
			companyDto.setPhone(company.getPhone());
			companyDto.setAddress(company.getAddress());
			companyDtos.add(companyDto);

		}
		return companyDtos;
	}
}
