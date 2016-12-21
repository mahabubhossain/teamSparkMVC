package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.aspect.annotation.Logging;
import edu.mum.dao.CredentialsDao;
import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.service.CredentialsService;

@Service
@Transactional	
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	//private MemberRestService memberRestService;
 	private MemberDao memberDao;
 	
 	@Autowired
 	private CredentialsService credentialsService;
 	//private CredentialsDao credentialsDao;
 	

 	@Logging
     public void save( Member member) {  		
    	//memberRestService.save(member);
    	memberDao.save(member);
	}
		
    @Override
   	public void saveFull( Member member) {  		
 		credentialsService.save(member.getUserCredentials());
 		//credentialsDao.save(member.getUserCredentials());
 		memberDao.save(member);
	}
  	

    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Member> findAll() {
		//return (List<Member>)memberRestService.findAll();
		return (List<Member>)memberDao.findAll(); 
	}

 
	public Member findOne(Long id) {
		//return memberRestService.findOne(id);
		return memberDao.findOne(id);
	}
	
 
	
 }
