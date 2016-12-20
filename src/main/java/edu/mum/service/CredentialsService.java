package edu.mum.service;

import edu.mum.domain.UserCredentials;
 
public interface CredentialsService {

	public void save(UserCredentials credentials);
	//public List<UserCredentials> findAll();
	public UserCredentials findOne(String id);
 }
