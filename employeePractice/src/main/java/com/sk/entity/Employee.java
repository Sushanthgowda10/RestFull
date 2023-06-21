package com.sk.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EId;
	
	@Column(length = 25)
	@NonNull
	private String EName;
	
	@Column(length = 25)
	@NonNull
	private String city;
	
	@Column(length = 25)
	@NonNull
	private String Gender;
	
	@Column
	@NonNull
	private Integer salary;
	


}
