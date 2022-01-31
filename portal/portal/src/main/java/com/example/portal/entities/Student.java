package com.example.portal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.portal.response.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Student {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotBlank(message="name should not be null")
	@Size(min=2,message="Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min=2,message="username should have at least 2 characters")
	private String username;
	
	@NotNull
	@Size(min=7,message="password should have at least 7 characters")
	private String password;

	

	
	

}
