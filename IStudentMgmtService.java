package com.ad.service;

import java.util.List;

import com.ad.model.Student;

public interface IStudentMgmtService {
public List<Student> getAllStudents();
public String registerStudent(Student std);
public Student getStudentByNo(int sno);
public String updateStudent(Student std);

}
