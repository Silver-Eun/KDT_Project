package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.MemberJoDTO;
import com.example.demo.entity.Member;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.example.demo.entity.QMember.member;
import static com.example.demo.entity.QJo.jo;
// => import static  
//	  기본 import 구문은 '패키지 명시 없이 클래스를 사용'하게 해 주는데, 
//	  import static 구문은 한 단계 더 들어가 '클래스 명시 없이 static변수나 static메서드를 사용'하게 해줌.

@Repository
public class MemberDSLRepositoryImpl implements MemberDSLRepository {
	
	private final JPAQueryFactory jPAQueryFactory;
	
	// => QueryDSL 적용
	//	  https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/
	// => QueryDSL 에서 DTO 적용하기
	//	  https://blog.naver.com/wjavmtngkr1/222926446084
	
	public MemberDSLRepositoryImpl(JPAQueryFactory jPAQueryFactory) {
		this.jPAQueryFactory=jPAQueryFactory;
	}
	
	// ** QueryDSL 적용
	// 1) Q클래스 return
	// => Parameter로 전달된 조원들만 출력하기 
	@Override
	public List<Member> findMemberJoDSL(int jno) {
		return jPAQueryFactory.selectFrom(member)
				.where(member.jno.eq(jno).and(member.point.goe(1000)))
				.orderBy(member.age.desc())
				.fetch();
	}
	
	// 2) Join & DTO return
	// => QueryDSL 에서 DTO 적용하기 ( 메모장 QueryDSL사용법.txt 참고 )
	//    ( 4종류 방법중 1) Setter 접근 또는 2) 필드 직접접근 적용
	// 2.1) Setter 접근
//	@Override
//	public List<MemberJoDTO> findMemberJoinDSL() {
//		return jPAQueryFactory.select(Projections.bean(MemberJoDTO.class, 
//				member.id, member.name, member.jno, jo.jname, jo.project)) 
//				.from(member)
//				.leftJoin(jo)
//				.on(member.jno.eq(jo.jno))
//				.fetchJoin()
//				.fetch();
//	}
	
	// 2.2) 필드 직접 접근
	// => DTO에 setter/getter 없어도 가능
	@Override
	public List<MemberJoDTO> findMemberJoinDSL() {
		return jPAQueryFactory.select(Projections.fields(MemberJoDTO.class, 
				member.id, member.name, member.jno, jo.jname, jo.project)) 
				.from(member)
				.leftJoin(jo)
				.on(member.jno.eq(jo.jno))
				.fetchJoin()
				.fetch();
	}
	
}
