package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberDTO {
	private String id; // Primary Key
	private String password; // not null
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	private String rid; // 추천인 추가
	private String uploadfile; // Table에 보관된 File_Path
	
	private MultipartFile uploadfilef;
}
