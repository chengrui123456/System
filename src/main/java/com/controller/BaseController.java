package com.controller;

import com.service.ProjectService;
import com.service.StudentService;
import com.service.SystemParameterService;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.CompanyService;

public class BaseController {
     @Autowired
     CompanyService companyService;
     @Autowired
     SystemParameterService systemParameterService;
     @Autowired
     StudentService studentService;
     @Autowired
     ProjectService projectService;

}
