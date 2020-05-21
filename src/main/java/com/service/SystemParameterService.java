
package com.service;

import com.dto.SystemParameterDto;
import com.entity.*;

import java.util.List;


public interface SystemParameterService {


	SystemParameterDto findSystem(String userName);

	void updateSystem(SystemParameterDto systemParameterDto);

	//第二部分
	List<Student> findStudentNo(Student student);

	List<ProjectSelect> findAllProjectSelect();

	List<Project> findByname(Project project);

	void  updateAudit(String no);

	List<Project> findAllProject();

	void insortNoticeAdmin(NoticeAdmin noticeAdmin);

	void deleteNoticeBySS(Integer id);

	List<NoticeAdmin> findAllNoticeAdmin();

	List<Company> findCompanyBysome(String company_name);

	void deleteBySS(String id);

	void updateBySs(Project project);

	List<Project> fineNoticeList(String companyUsername);

	List<Company> findAllCompany();

	SystemParameterDto Login(String username);
	

}
