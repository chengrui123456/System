package com.service;


import java.util.ArrayList;
import java.util.List;


import com.dto.ProjectDto;
import com.dto.ProjectSelectDto;
import com.entity.Project;


public interface ProjectService {

	
	public boolean addProject(ProjectDto p);

	
	public int CountSelectProject();

	
	public ArrayList<ProjectSelectDto> SearchProject();

	
	
	public boolean updateProject(ProjectDto p);

	
	public ArrayList<ProjectDto> findAllProject(int role, String company_username);

	
	public boolean deleteProject(String p_no);

	
	public boolean checkProject(String p_no, boolean check);

	
	public boolean summaryProject(String p_no, String content);

	
	public boolean endProjects(String p_nos[]);

	
	public ArrayList<ProjectDto> findAllProject(int grade);

	
	public int countStartProject();

	
	public boolean chooseProject(String company_name, String p_no, String stu_no, String reason);

	
	public boolean unChooseProject(String p_no, String stu_no);

	
	public ArrayList<ProjectSelectDto> findAllStudentChoice(String c_name);

	
	public boolean chooseStudent(String stu_no, String p_no);

	public boolean unChooseStudent(String stu_no, String p_no);

	
	public ArrayList<ProjectSelectDto> findReason(int type, String p_no);

	
	public boolean inputScore(String stu_nos, String scores, String p_no);

	
	public ArrayList<ProjectSelectDto> findScore(String s_no, Integer typeId);
	public ArrayList<ProjectSelectDto> findAllScore(String s_no);

	
	public int countProject();

	public int countCompanyProject(String company_username);

	
	public ProjectDto findProjectByNo(String no);

	
	public int findMaxProjectNo(int year);

	
	public ArrayList<ProjectDto> findAllStartedProject();

	
	public ArrayList<ProjectDto> findAllChosenProject(String stu_no);

	public List<Project> findAllProjectByStu(String stu_no);

	
	public int countAllStudentChoice(String c_name);

	
	public int countAllStudentChoiceByPNoAndType(String p_no, String type);

	
	public ArrayList<ProjectDto> findAllProject(int role, String company_username, boolean checkState,
                                                String year);

	
	public int countProject(String year, boolean checkState, String company_username);

	
	public ArrayList<ProjectDto> findAllProject(String company_username);

	
	public int countAllSelStuByNo(String no);

	
	public ArrayList<Project> findStuProject(String stu_no);

	public void deleProjectByProjectNo(String projectNo, String stu_no);

	public List<Project> findAllProjectByThree(String stu_no, String name, String price, Integer typeId);

	public 	String findCompany_name(String projectId);
	
	public ArrayList<String> findAllProfessional();

	void insertProjectIntoSelect(String stu_no, String projectId, String sel_reason, String company_name);



	boolean findStuProjectTure(String no, String projectId);
}
