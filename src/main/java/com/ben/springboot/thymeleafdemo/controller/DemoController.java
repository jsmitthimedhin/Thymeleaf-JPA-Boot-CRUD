package com.ben.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ben.springboot.thymeleafdemo.entity.Member;
import com.ben.springboot.thymeleafdemo.service.MemberService;

@Controller
public class DemoController {
	private MemberService memberService;
	private List<Member> members;
	
@Autowired
	public DemoController(MemberService memberService) {
		this.memberService = memberService;
}
	
	@GetMapping("/members")
	public String showPage(Model model, String keyword) {
		members = new ArrayList<>();
		members = memberService.findAll();
		
		if(keyword!=null) {
			model.addAttribute("members", memberService.findByKeyword(keyword));
		} else {
			model.addAttribute("members", members);
		}
		return "home";
	}
	
	@GetMapping("/members/add")
	public String addMember(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "member-form";
	}
	
	@PostMapping("/members/save")
	public String saveMember(@ModelAttribute("member") Member member) {
		
		memberService.saveMember(member);
		return "redirect:/members";
	}
	
	@GetMapping("/members/update")
	public String updateMember(@RequestParam("memberId") int memberId, Model model) {
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "member-form";
	}
	
	@GetMapping("/members/delete")
	public String deleteMember(@RequestParam("memberId") int memberId) {
		Member member = memberService.getMember(memberId);
		memberService.deleteMember(memberId);
		return "redirect:/members";
		
	}
	
	
	
}
