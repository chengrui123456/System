package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentMapper;
import com.dto.StudentDto;
import com.entity.Student;
import com.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public StudentDto Login(String no) {
		Student student=new Student();
		StudentDto studentDto=new StudentDto();
		student=studentMapper.selectByPrimaryKey(no);
		studentDto.setNo(student.getNo());
		studentDto.setPassword(student.getPassword());
		return studentDto;		
	}
	@Override
	public void insert(StudentDto studentDto) {
		Student student = new Student();
		student.setNo(studentDto.getNo());
		student.setName(studentDto.getName());
		student.setGrade(studentDto.getGrade());
		student.setLevel(studentDto.getLevel());
		student.setProfessional(studentDto.getProfessional());
		student.setGender(studentDto.getGender());
		student.setClasss(studentDto.getClass_());
		student.setPassword(studentDto.getPassword());
		student.setMailbox(studentDto.getMailbox());
		student.setSubject_background(studentDto.getSubjectBackground());
		student.setLearning_experience(studentDto.getLearningExperience());
		student.setResearch_direction(studentDto.getResearchDirection());
		studentMapper.insertStudent(student.getNo(),student.getName(),student.getGrade(),student.getProfessional(),student.getGender(),student.getClasss(),student.getPassword());

	}
	@Override
	public List<StudentDto> findAll() {
		List<Student> students = studentMapper.selectAllStudent();
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student :students){
			StudentDto studentDto=new StudentDto();
			studentDto.setNo(student.getNo());
			studentDto.setName(student.getName());
			studentDto.setGrade(student.getGrade());
			studentDto.setProfessional(student.getProfessional());
			studentDto.setGender(student.getGender());
			studentDto.setMailbox(student.getMailbox());
			studentDtos.add(studentDto);
		}
		return studentDtos;
	}
	@Override
	public int countStudent() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Student findById(String id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<StudentDto> findBySelected(int flag) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StudentDto> findByCompany(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StudentDto> findByGrade(int grade) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StudentDto> findByMajor(String major) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StudentDto> findByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<StudentDto> findByProcdure(String procdure) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean findByProcdure(String procdure, Object[] params) {
		// TODO Auto-generated method stub
		return false;
	}
	//更新学生信息
	@Override
	public void update(StudentDto studentDto) {
		Student student = new Student();
		student.setNo(studentDto.getNo());
		student.setName(studentDto.getName());
		student.setGrade(studentDto.getGrade());
		student.setLevel(studentDto.getLevel());
		student.setProfessional(studentDto.getProfessional());
		student.setGender(studentDto.getGender());
		student.setClasss(studentDto.getClass_());
		student.setPassword(studentDto.getPassword());
		student.setMailbox(studentDto.getMailbox());
		student.setSubject_background(studentDto.getSubjectBackground());
		student.setLearning_experience(studentDto.getLearningExperience());
		student.setResearch_direction(studentDto.getResearchDirection());
		studentMapper.updateByPrimaryKeySelective(student);


	}

	@Override
	public void updatePassword(String studentNo, String newPassword) {
		Student student=new Student();
		student.setNo(studentNo);
		student.setPassword(newPassword);
		studentMapper.updateByPrimaryKeySelective(student);

	}

	@Override
	public void delete(String id) {
		studentMapper.deleteByPrimaryKey(id);

	}
	@Override
	public boolean importStudent(List<StudentDto> list) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean exportStudent(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

}
