
package com.service;

import java.sql.Date;
import java.util.List;
import com.dto.CompanyDto;
import com.dto.NoticeCompanyDto;
import com.dto.ProjectDto;
import com.entity.*;
import com.github.pagehelper.PageInfo;


public interface CompanyService {

	//公告
	void updateNoticeCompany(NoticeCompany noticeCompany);

	NoticeCompany findNoticeCompanyById(Integer id);

	List<NoticeCompany> findNoticeCompany(String company_username);

	void insortNoticeCompany(NoticeCompany noticeCompany);

	List<Project> findByNoaduitProjectList(Project project);

	List<Project> findByProjectSome(Project project);


//企业打分，学生选课信息
	void deleteProjectSelects(String no);

	void UpdateCompnaySelects(ProjectSelect projectSelect);

	ProjectSelect findCompanySelect(String no);

	List<ProjectSelect> findByProjectScoreSome(ProjectSelect projectSelect);

	List<ProjectSelect> findByProjectSelect(String company_username);



	void updateProject(ProjectDto projectDto);

	Project ListByNo(String No);

	Void deleteByExample(String No);

	public String getProjectNo(Integer m);

	public List<NoticeCompany> findAllNoticeCompanyByPage();

	public List<Project> selectByUsernameAndPage(String username);
	
	CompanyDto Login(String username);
	
	void registerCompanyInfo(CompanyDto company);

	
	void updateCompanyInfo(CompanyDto company);

	void insertProject(ProjectDto projectDto);
	
	void updateCompanyPassword(String companyUserName, String newPassword);


	
	List<CompanyDto> listAllCompanys();

	
	void deleteCompanyByUsername(String companyUsername);

	
	void checkCompany(CompanyDto companyDto);

	
	Company listByUserName(String username);

	SystemParameter systemparameter(String vscode);


	List<NoticeCompanyDto> listAllNotice();


	List<CompanyDto> findAllCompany();

	void deleteCompany(String company_name);

	List<CompanyDto> findCompanyByName(String company_name);

	
}
