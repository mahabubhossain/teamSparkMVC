package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Logging;
import edu.mum.domain.Member;
import edu.mum.rest.service.MemberRestService;
import edu.mum.service.CredentialsService;

@Service
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberRestService memberRestService;
 	
 	@Autowired
 	private CredentialsService credentialsService;
 	

 	@Logging
     public void save( Member member) {  		
    	memberRestService.save(member);
	}
		
    @Override
   	public void saveFull( Member member) {  		
 		credentialsService.save(member.getUserCredentials());
	}
  	

	public List<Member> findAll() {
		return (List<Member>)memberRestService.findAll();
	}

 
	public Member findOne(Long id) {
		return memberRestService.findOne(id);
	}
	
 
	
 }
