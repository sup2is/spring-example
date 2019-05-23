package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "usr")
public class User {

	@Id
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	
}
