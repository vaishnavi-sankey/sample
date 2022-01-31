package com.example.portal.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.portal.entities.Student;
import com.example.portal.response.ResourceNotFoundException;
import com.example.portal.services.StudentService;


import org.springframework.http.ResponseEntity;






@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
	
	
    //GET CRUDE OPERATIONS
    
    
	//GetStudentData using ResponseEntity
	 @GetMapping("/student")
	    public List<Student> fetchStudentList() 
	    {
           return studentService.fetchStudentList();

	    }
	
	
	
	 
	//GetStudentDataById 
	 @GetMapping("/student/{studentId}")
	  public Student getStudent( @PathVariable(name = "studentId") Long studentId)
	    {
	     
	        return studentService.getStudent(studentId);
	    
	    }
	 
	

	
	
             //ADD CRUDE OPERATUINS
    
	    
	        //AddMultipleStudentData 
	        @PostMapping("/student")
	        public List<Student> addStudents(@Valid @RequestBody List<Student> student)
	        {
		       return studentService.addStudents(student);

	        }
	 
	 
       
	        
	        //UPDATE CRUDE OPERATIONS
	        
	        
	        
	        //UpdateStudentDataById
	        @PutMapping("/student/{studentId}")
	        public Student updateStudent( @PathVariable("studentId") Long studentId, @RequestBody Student student)
	        {
                  return studentService.updateStudent(student, studentId);
                    
	        }
	        
	
	        
	        
	        //DELETE CRUDE OPERATIONS
	        
	        
	        
	      //deleteStudentDataById using ResponseEntity
	        @DeleteMapping("/student/{studentId}")
	        public String deleteStudent(@PathVariable(name = "studentId") Long studentId)
	        {
	            return studentService.deleteStudent(studentId);
	        }
	        
	        
	        

	       
}
