package com.service.impl;

import com.dao.*;
import com.dto.SystemParameterDto;
import com.entity.*;
import com.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SystemParameterServiceImpl implements SystemParameterService {
    @Autowired
    SystemParameterMapper systemParameterMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    NoticeAdminMapper noticeAdminMapper;
    @Autowired
    ProjectSelectMapper projectSelectMapper;

    @Override
    public List<Student> findStudentNo(Student student) {

        return null;
    }

    @Override
    public List<ProjectSelect> findAllProjectSelect() {
        ProjectSelectExample example=new ProjectSelectExample();
        List<ProjectSelect> projectSelects=projectSelectMapper.selectByExample(example);
        return projectSelects;
    }

    @Override
    public List<Project> findByname(Project project) {
        List<Project> projects=projectMapper.findByname(project);
        return projects;
    }

    @Override
    public void updateAudit(String no) {
        projectMapper.updateauditdate(no);
    }

    @Override
    public List<Project> findAllProject() {
        return projectMapper.findAllProject();
    }

    @Override
    public void insortNoticeAdmin(NoticeAdmin noticeAdmin) {
        noticeAdminMapper.insertSelective(noticeAdmin);
    }

    @Override
    public void deleteNoticeBySS(Integer id) {
        noticeAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<NoticeAdmin> findAllNoticeAdmin() {

        return noticeAdminMapper.findAllNoticeAdmin();
    }

    @Override
    public List<Company> findCompanyBysome(String company_name) {
        List<Company>  companys=companyMapper.findCompanyBySome(company_name);
        return companys;
    }

    @Override
    public void deleteBySS(String id) {
        projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateBySs(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public List<Project> fineNoticeList(String companyUsername) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria=example.createCriteria();
        criteria.andCompany_usernameEqualTo(companyUsername);

        return projectMapper.selectByExample(example);
    }

    @Override
    public List<Company> findAllCompany() {

        return companyMapper.findAllCompany();
    }

    @Override
    public SystemParameterDto Login(String username) {
        SystemParameter systemParameter=new SystemParameter();
        SystemParameterDto systemParameterDto=new SystemParameterDto();
        systemParameter=systemParameterMapper.findById(username);
        systemParameterDto.setAdminUsername(systemParameter.getAdmin_username());
        systemParameterDto.setAdminPassword(systemParameter.getAdmin_password());
        return systemParameterDto;

    }



    @Override
    public SystemParameterDto findSystem(String userName) {
        SystemParameter systemParameter=new SystemParameter();
        SystemParameterDto systemParameterDto=new SystemParameterDto();
        systemParameter = systemParameterMapper.findMessage(userName);
        systemParameterDto.setAdminUsername(systemParameter.getAdmin_username());
        systemParameterDto.setAdminPassword(systemParameter.getAdmin_password());
        systemParameterDto.setInvitationCode(systemParameter.getInvitation_code());
        systemParameterDto.setReleaseProjectStartDate(systemParameter.getRelease_project_start_date());
        systemParameterDto.setReleaseProjectEndDate( systemParameter.getRelease_project_end_date());
        systemParameterDto.setStudentSelStartDate(systemParameter.getStudent_sel_start_date());
        systemParameterDto.setStudentSelEndDate(systemParameter.getStudent_sel_end_date());
        systemParameterDto.setStudentSelMaxnum(systemParameter.getStudent_sel_maxnum());

        return systemParameterDto;
    }

    @Override
    public void updateSystem(SystemParameterDto systemParameterDto) {
        SystemParameter systemParameter=new SystemParameter();
        systemParameter.setAdmin_username(systemParameterDto.getAdminUsername());
        systemParameter.setAdmin_password(systemParameterDto.getAdminPassword());
        systemParameter.setInvitation_code(systemParameterDto.getInvitationCode());
        systemParameter.setRelease_project_end_date(systemParameterDto.getReleaseProjectEndDate());
        systemParameter.setRelease_project_start_date(systemParameterDto.getReleaseProjectStartDate());
        systemParameter.setStudent_sel_start_date(systemParameterDto.getStudentSelStartDate());
        systemParameter.setStudent_sel_end_date(systemParameterDto.getStudentSelEndDate());
        systemParameter.setStudent_sel_maxnum(systemParameterDto.getStudentSelMaxnum());
        systemParameterMapper.updateSystem(systemParameter.getAdmin_password(),systemParameter.getInvitation_code(),systemParameter.getRelease_project_start_date(),systemParameter.getRelease_project_end_date(),systemParameter.getStudent_sel_start_date(),systemParameter.getStudent_sel_end_date(),systemParameter.getStudent_sel_maxnum(),systemParameter.getAdmin_username());
    }
}
