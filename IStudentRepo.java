package com.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ad.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
