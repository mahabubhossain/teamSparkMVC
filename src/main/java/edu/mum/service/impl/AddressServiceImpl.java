package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.aspect.annotation.Logging;
import edu.mum.domain.Address;
import edu.mum.rest.service.AddressRestService;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	
	
 	@Autowired
	//private AddressDao memberDao;
 	private AddressRestService addressRestService;

 	@Logging
    public void save( Address address) {  		
    	addressRestService.save(address);
	}
	
	
    /*public void update( Address address) {  		
		memberDao.update(address);
	}*/
	
	
	/*public List<Address> findAll() {
		return (List<Address>)addressRestService.findAll();
	}
*/
 	public Address findOne(Long id) {
		return addressRestService.findOne(id);
	}


	
 
}
