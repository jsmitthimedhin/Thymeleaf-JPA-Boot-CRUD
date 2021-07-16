package com.ben.springboot.thymeleafdemo.service;

import java.util.List;

import com.ben.springboot.thymeleafdemo.entity.Member;

public interface MemberService {
	public List<Member> findAll();

	public Member getMember(int id);

	public void saveMember(Member newMember);

	public void deleteMember(int memberId);
	
	List<Member> findByKeyword(String keyword);
}
