package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import edu.mum.aspect.annotation.Logging;
import edu.mum.dao.CredentialsDao;
//import edu.mum.dao.CredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.rest.service.UserCredentialsRestService;
import edu.mum.service.CredentialsService;

@Service
@Transactional 
public class CredentialsServiceImpl implements CredentialsService {
	
 	//@Autowired
	//private UserCredentialsRestService credentialsRestService;
 	
 	@Autowired
 	private CredentialsDao credentialsDao;

 	@Logging
   	public void save(UserCredentials credentials) {

  		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(credentials.getPassword());
  		credentials.setPassword(encodedPassword);
  		
  		//credentialsRestService.save(credentials);
  		credentialsDao.save(credentials);
	}
	/*public List<UserCredentials> findAll() {
		return (List<UserCredentials>)credentialsRestService.findAll();
	}*/
	@Override
	@Logging
	public UserCredentials findOne(String id) {
		// TODO Auto-generated method stub
		//return credentialsRestService.findOne(id);
		return credentialsDao.findByUserName(id);
	}

 
}
