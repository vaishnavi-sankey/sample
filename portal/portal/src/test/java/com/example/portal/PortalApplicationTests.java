package com.example.portal;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.portal.entities.Student;
import com.example.portal.repository.StudentRepository;


@SpringBootTest
@TestClassOrder(OrderAnnotation.class)
class PortalApplicationTests {



	@Autowired
	private StudentRepository studentRepository;
	
	
	@Test
	@Order(1)
	public void testAdd()
	{
		Student student=new Student();
		student.setId((long) 3);
		student.setName("vaishnavi");
		student.setEmail("vl@gmail.com");
		student.setUsername("vaishnavi");
		student.setPassword("vvvvvv");
		studentRepository.save(student);
		assertNotNull(studentRepository.findById((long) 3).get());
		
		
	}
	
	
	@Test
	@Order(2)
	public void getAll()
	{
		List<Student> list =(List<Student>) studentRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testgetById()
	{
		
		Student student=studentRepository.findById((long) 1).get();
		assertEquals("vaishnavi", student.getName());
	
		
	}
	
	@Test
	@Order(4)
	public void testUpdateById()
	{
		
		Student student=studentRepository.findById((long) 1).get();
		student.setName("akshata");
		studentRepository.save(student);
		assertNotEquals("vaishnavi", studentRepository.findById((long) 1).get().getName());
		
	}
	
	@Test
	@Order(5)
	public void testDeleteById()
	{
		
		studentRepository.deleteById((long) 1);
		assertThat(studentRepository.existsById((long)1)).isFalse();
		
	}
	
	
}
