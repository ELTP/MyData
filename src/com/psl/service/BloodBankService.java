package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.DAO.IDonarDAO;
import com.psl.bean.Admin;
import com.psl.bean.Donor;
@Component
public class BloodBankService {
	
	@Autowired
	private IDonarDAO dao;
	public void addDonar(Donor d) {
		dao.addDonar(d);
	}

	public List<Donor> getAllDonar() {
		return dao.getAllDonar();
	}
	
	public int userLogin(Admin a) {
		
		return dao.userLogin(a);
		
	}
	
	public void updateBloodGroup(String bg,String donorId){
		dao.updateBloodGroup(bg, donorId);
	}
	
	public List< Donor> getDonor(String user){
		return dao.getDonor(user);
		
	}
}
