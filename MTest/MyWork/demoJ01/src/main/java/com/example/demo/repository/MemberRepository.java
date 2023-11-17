package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;

//import criTest.SearchCriteria;

public interface MemberRepository 
					extends JpaRepository<Member, String> {
}
