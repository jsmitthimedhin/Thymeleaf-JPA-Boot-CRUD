package com.ben.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ben.springboot.thymeleafdemo.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public List<Member> findAllByOrderByLastNameAsc();
	
	@Query(value="SELECT * FROM member e WHERE e.first_name LIKE %:keyword% OR e.last_name LIKE %:keyword% OR e.email LIKE %:keyword%", nativeQuery=true)
	List<Member> findByKeyword(@Param("keyword") String keyword);
}
