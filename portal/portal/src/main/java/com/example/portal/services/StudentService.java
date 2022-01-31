package com.example.portal.services;

import java.util.List;


import com.example.portal.entities.Student;

public interface StudentService {
	
	
	List<Student> fetchStudentList();
	
	Student getStudent(Long studentId);
	
	List<Student> addStudents(List<Student> student);
	
    Student updateStudent(Student student,Long studentId);
    
    String deleteStudent(Long studentId);
	

}
