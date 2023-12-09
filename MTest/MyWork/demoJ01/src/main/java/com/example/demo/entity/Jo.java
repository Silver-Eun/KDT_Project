package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="jo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jo {
	
	@Id
	private int jno;
	private String jname;
	private String id;
	private String project;
	private String slogan;
	
} //class
