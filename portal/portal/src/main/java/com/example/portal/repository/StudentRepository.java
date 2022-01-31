package com.example.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.portal.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
