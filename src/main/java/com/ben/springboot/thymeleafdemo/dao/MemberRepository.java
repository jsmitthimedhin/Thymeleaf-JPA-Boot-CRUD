package com.ben.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ben.springboot.thymeleafdemo.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public List<Member> findAllByOrderByLastNameAsc();
}
