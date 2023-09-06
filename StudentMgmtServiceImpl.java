package com.ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ad.model.Student;

import com.ad.repository.IStudentRepo;
@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
@Autowired
private IStudentRepo Repo;
	@Override
	public List<Student> getAllStudents() {
		
		return Repo.findAll();
	}
	public String registerStudent(Student std) {
		return"Student is saved with id value:"+Repo.save(std).getSno();
	}
	public Student getStudentByNo(int sno) {
		Student std=Repo.findById(sno).orElseThrow(()->new IllegalArgumentException());
		return std;
	}
	public String updateStudent(Student std) {
		return"Student is updated having id value:"+Repo.save(std).getSno();
	}
	/*public String deleteEmployee(int eno) {
		empRepo.deleteById(eno);
		return eno+"Id value Employee is deleted!!";
	}*/
	
}
