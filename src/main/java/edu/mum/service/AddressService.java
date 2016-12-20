package edu.mum.service;

import edu.mum.domain.Address;
 
public interface AddressService {

	public void save(Address address);
	//public void update(Address address);
	//public List<Address> findAll();
 
	public Address findOne(Long id);

}
