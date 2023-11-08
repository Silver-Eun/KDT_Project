package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 값을 초기화하는 생성자
@NoArgsConstructor // default 생성자
public class JoDTO {
	private int jno;
	private String jname;
	private String id;
	private String project;
	private String slogan;
	
	private String cname;
}
