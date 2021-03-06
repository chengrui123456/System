package com.dao;

import com.entity.SystemParameter;
import com.entity.SystemParameterExample;

import java.util.Date;
import java.util.List;

public interface SystemParameterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_parameter
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    int insert(SystemParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_parameter
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    int insertSelective(SystemParameter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_parameter
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    List<SystemParameter> selectByExample(SystemParameterExample example);

    SystemParameter findById(String username);

    SystemParameter findMessage(String userName);

    void updateSystem(String admin_password, String invitation_code, Date release_project_start_date, Date release_project_end_date, Date student_sel_start_date, Date student_sel_end_date, Integer student_sel_maxnum, String admin_username);

}