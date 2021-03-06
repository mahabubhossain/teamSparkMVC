package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Member;

@Component
public interface MemberRestService {

 	public List<Member> findAll();

	public Member findOne(Long index);

	public Member save(Member member);

}
