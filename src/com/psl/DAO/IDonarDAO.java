package com.psl.DAO;

import java.util.List;

import com.psl.bean.Admin;
import com.psl.bean.Donor;

public interface IDonarDAO {

	public void addDonar(Donor d);

	List<Donor> getAllDonar();

	public void updateBloodGroup(String bg,String donorId);
	
	public int userLogin(Admin a);
	List< Donor> getDonor(String user);
}
