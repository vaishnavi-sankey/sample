package com.example.portal.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portal.entities.Student;
import com.example.portal.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	 private StudentRepository studentRepository;
	
	
	//GetStudentData
	@Override
	public List<Student> fetchStudentList()
	{
		return (List<Student>) studentRepository.findAll();
		
	}
	
	
	
	 //GetStudentDataById
	 @Override
	 public Student getStudent(Long studentId) 
	   {
	      return studentRepository.findById(studentId).get();
	   }
		
	
	
	//AddMultipleStudentData
	@Override
	public List<Student> addStudents(List<Student> student)
	{
		return (List<Student>) studentRepository.saveAll(student);
	}
	

	
	//UpdateStudentData
	@Override
	public Student updateStudent(Student student,Long studentId)
	{
		Student SD= studentRepository.findById(studentId).get();

		
		SD.setName(student.getName());
		SD.setEmail(student.getEmail());
		SD.setUsername(student.getUsername());
		SD.setPassword(student.getPassword());
	    return studentRepository.save(SD);
	}
		
	

	
	//deleteStudentData using ResponseEntity
	 @Override
	    public String deleteStudent(Long studentId) {
		  studentRepository.deleteById(studentId);
		  return null;
	    }
	 
	 

	
}
