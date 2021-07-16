package com.ben.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.ben.springboot.thymeleafdemo.dao.MemberRepository;
import com.ben.springboot.thymeleafdemo.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Member getMember(int id) {
		Optional<Member> result = memberRepository.findById(id);
		if(result.isPresent()) {
			Member member = result.get();
			return member;
		} else {
			throw new RuntimeException("Could not find a member with the following ID: " + id);
		}
	}

	@Override
	public void saveMember(Member newMember) {
		memberRepository.save(newMember);
	}

	@Override
	public void deleteMember(int memberId) {
		memberRepository.deleteById(memberId);
		
	}

}
