package com.service;

import java.util.List;

import com.dto.StudentDto;
import com.entity.Student;


public interface StudentService {
	
	StudentDto Login(String no);
	
	public void insert(StudentDto student);

	
	public List<StudentDto> findAll();

	
	public int countStudent();

	
	public Student findById(String id);

	
	public List<StudentDto> findBySelected(int flag);

	
	public List<StudentDto> findByCompany(String companyName);

	
	public List<StudentDto> findByGrade(int grade);

	
	public List<StudentDto> findByMajor(String major);

	
	public List<StudentDto> findByYear(int year);

	public List<StudentDto> findByProcdure(String procdure);

	
	public boolean findByProcdure(String procdure, Object[] params);

	
	public void update(StudentDto student);

	public void updatePassword(String no, String newPassword);
	
	public void delete(String id);

	
	
	public boolean importStudent(List<StudentDto> list);

	
	public boolean exportStudent(String fileName);


}
