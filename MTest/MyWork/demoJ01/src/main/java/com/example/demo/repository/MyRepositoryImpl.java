package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;

@Transactional
@Repository
public class MyRepositoryImpl implements MyRepository {
	
	private final EntityManager em;
	
	public  MyRepositoryImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<Member> adminMemberList() {
		return em.createQuery("SELECT m FROM Member m ORDER BY m.id ASC"
								, Member.class).getResultList();
	}

}
