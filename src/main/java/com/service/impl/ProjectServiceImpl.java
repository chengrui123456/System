package com.service.impl;

import com.dao.CompanyMapper;
import com.dao.ProjectMapper;
import com.dao.ProjectSelectMapper;
import com.dto.ProjectDto;
import com.dto.ProjectSelectDto;
import com.entity.Project;
import com.entity.ProjectSelect;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    ProjectSelectMapper projectSelectMapper;
    @Autowired
    ProjectMapper projectMapper;


    @Override
    public boolean addProject(ProjectDto p) {
        return false;
    }

    @Override
    public int CountSelectProject() {
        return 0;
    }

    @Override
    public ArrayList<ProjectSelectDto> SearchProject() {
        return null;
    }

    @Override
    public boolean updateProject(ProjectDto p) {
        return false;
    }

    @Override
    public ArrayList<ProjectDto> findAllProject(int role, String company_username) {
        return null;
    }

    @Override
    public boolean deleteProject(String p_no) {
        return false;
    }

    @Override
    public boolean checkProject(String p_no, boolean check) {
        return false;
    }

    @Override
    public boolean summaryProject(String p_no, String content) {
        return false;
    }

    @Override
    public boolean endProjects(String[] p_nos) {
        return false;
    }

    @Override
    public ArrayList<ProjectDto> findAllProject(int grade) {
        return null;
    }

    @Override
    public int countStartProject() {
        return 0;
    }

    @Override
    public boolean chooseProject(String company_name, String p_no, String stu_no, String reason) {
        return false;
    }

    @Override
    public boolean unChooseProject(String p_no, String stu_no) {
        return false;
    }

    @Override
    public ArrayList<ProjectSelectDto> findAllStudentChoice(String c_name) {
        return null;
    }

    @Override
    public boolean chooseStudent(String stu_no, String p_no) {
        return false;
    }

    @Override
    public boolean unChooseStudent(String stu_no, String p_no) {
        return false;
    }

    @Override
    public ArrayList<ProjectSelectDto> findReason(int type, String p_no) {
        return null;
    }

    @Override
    public boolean inputScore(String stu_nos, String scores, String p_no) {
        return false;
    }

    @Override
    public ArrayList<ProjectSelectDto> findAllScore(String s_no) {
        List<ProjectSelect> scores = projectSelectMapper.findAllScore(s_no);
        List<ProjectSelectDto> projectSelectDtos = new ArrayList<>();
        for (ProjectSelect projectSelect :scores){
            ProjectSelectDto projectSelectDto = new ProjectSelectDto();
            projectSelectDto.setStudentNo(projectSelect.getStudentNo());
            projectSelectDto.setCompanyName(projectSelect.getCompany_name());
            projectSelectDto.setCompanySelDate(projectSelect.getCompany_sel_date());
            projectSelectDto.setProjectNo(projectSelect.getProjectNo());
            projectSelectDto.setScore(projectSelect.getScore());
            projectSelectDto.setSelReason(projectSelect.getSel_reason());
            projectSelectDtos.add(projectSelectDto);
        }
        return (ArrayList<ProjectSelectDto>) projectSelectDtos;
    }

    @Override
    public ArrayList<ProjectSelectDto> findScore(String stu_no, Integer typeId) {
        List<ProjectSelect> scores = projectSelectMapper.findScore(stu_no,typeId);
        List<ProjectSelectDto> projectSelectDtos = new ArrayList<>();
        for (ProjectSelect projectSelect :scores){
            ProjectSelectDto projectSelectDto = new ProjectSelectDto();
            projectSelectDto.setStudentNo(projectSelect.getStudentNo());
            projectSelectDto.setCompanyName(projectSelect.getCompany_name());
            projectSelectDto.setCompanySelDate(projectSelect.getCompany_sel_date());
            projectSelectDto.setProjectNo(projectSelect.getProjectNo());
            projectSelectDto.setScore(projectSelect.getScore());
            projectSelectDto.setSelReason(projectSelect.getSel_reason());
            projectSelectDtos.add(projectSelectDto);
        }
        return (ArrayList<ProjectSelectDto>) projectSelectDtos;
    }

    @Override
    public int countProject() {
        return 0;
    }

    @Override
    public int countCompanyProject(String company_username) {
        return 0;
    }

    @Override
    public ProjectDto findProjectByNo(String no) {
        return null;
    }

    @Override
    public int findMaxProjectNo(int year) {
        return 0;
    }

    @Override
    public ArrayList<ProjectDto> findAllStartedProject() {
        return null;
    }

    @Override
    public ArrayList<ProjectDto> findAllChosenProject(String stu_no) {
        return null;
    }

    @Override
    public List<Project> findAllProjectByStu(String stu_no) {
        List<Project> projects =  projectMapper.selectProjectByStu(stu_no);
//        List<ProjectDto> articles = new ArrayList<>();
//        for (Project project :projects){
//            ProjectDto projectDto = new ProjectDto();
//            projectDto.setNo(project.getNo());
//            projectDto.setName(project.getName());
//            projectDto.setIntroduction(project.getIntroduction());
//            projectDto.setStudentsNum(project.getStudents_num());
//            projectDto.setCompanyUsername(project.getCompany_username());
//            projectDto.setCompanyTeacher(project.getCompany_teacher());
//            projectDto.setCompanyTeacherTitle(project.getCompany_teacher_title());
//            projectDto.setReleaseDate((Date) project.getRelease_date());
//            projectDto.setAuditDate((Date) project.getAudit_date());
//            projectDto.setEndDate((Date) project.getEnd_date());
//            projectDto.setSummary(project.getSummary());
//            projectDto.setGrade(project.getGrade());
//            projectDto.setGrade(project.getGrade());
//            projectDto.setMajor(project.getMajor());
//            articles.add(projectDto);
//        }
        return  projects;
    }

    @Override
    public int countAllStudentChoice(String c_name) {
        return 0;
    }

    @Override
    public int countAllStudentChoiceByPNoAndType(String p_no, String type) {
        return 0;
    }

    @Override
    public ArrayList<ProjectDto> findAllProject(int role, String company_username, boolean checkState, String year) {
        return null;
    }

    @Override
    public int countProject(String year, boolean checkState, String company_username) {
        return 0;
    }

    @Override
    public ArrayList<ProjectDto> findAllProject(String company_username) {
        return null;
    }

    @Override
    public int countAllSelStuByNo(String no) {
        return 0;
    }

    @Override
    public ArrayList<Project> findStuProject(String stu_no) {
        List<Project> projectByStuNos = projectMapper.findProjectByStuNo(stu_no);
        return (ArrayList<Project>) projectByStuNos;
    }

    @Override
    public void deleProjectByProjectNo(String projectNo,String stu_no) {

        projectSelectMapper.deleProjectByProjectNo(projectNo,stu_no);
    }

    @Override
    public List<Project> findAllProjectByThree(String stu_no,String name, String price, Integer typeId) {
        List<Project> allProjectByThree = projectMapper.findAllProjectByThree(stu_no, name, price, typeId);
        return  allProjectByThree;
    }

    @Override
    public String findCompany_name(String projectId) {
        Project project = projectMapper.findCompany_name(projectId);
        String company_username =project.getCompany_username();
        return  company_username;
    }

    @Override
    public ArrayList<String> findAllProfessional() {
        return null;
    }

    @Override
    public void insertProjectIntoSelect(String stu_no, String projectId, String sel_reason, String company_name) {
        projectSelectMapper.insertProjectIntoSelect(stu_no,projectId,sel_reason,company_name);
    }

    @Override
    public boolean findStuProjectTure(String no, String projectId) {
        ProjectSelect p = projectSelectMapper.findStuProjectTure(no, projectId);
        if (null==p||null==p.getCompany_name()){
            System.out.println("--------");
            return false;
        }
        return true;
    }
}
