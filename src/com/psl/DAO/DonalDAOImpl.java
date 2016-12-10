package com.psl.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.psl.bean.Admin;
import com.psl.bean.Donor;
import com.psl.controller.DonorController;

@Component(value = "dao")
public class DonalDAOImpl implements IDonarDAO {
	@Autowired
	JdbcTemplate template;
	@Override
	public void addDonar(Donor d) {
		template.update("insert into donor values (" + d.getDonerId() + ",'"
				+ d.getDonarName() + "'," + d.getAge() + "," + d.getContact()+ ",'"+d.getBloodgroup()+"') ");
		System.out.println("inserted...");
	}
	@Override
	public List<Donor> getAllDonar() {
		return template.query("select * from donor", new RowMapper<Donor>() {
			@Override
			public Donor mapRow(ResultSet rs, int arg1) throws SQLException {
				Donor d = new Donor();
				d.setDonerId(rs.getInt("donorId"));
				d.setDonarName(rs.getString("donorName"));
				d.setAge(rs.getInt("donorAge"));
				d.setContact(rs.getLong("contact"));
				d.setBloodgroup(rs.getString("bloodgroup"));
				return  d;
			}
		});
	}
	
	@Override
	public void updateBloodGroup(String bg,String donorId) {
		template.update(" update donor set bloodgroup='"+bg+"' where donorId="+donorId);
	}

	@Override
	public int userLogin(Admin a) {
		//List<Admin> list=new ArrayList<Admin>();
		List<Admin> list	= template.query("select * from admin where username='"+a.getUsername()+"' and password='"+ a.getPassword()+" ' ",new RowMapper<Admin>() {
			@Override
			public Admin mapRow(ResultSet rs, int arg1) throws SQLException {
				Admin ad=new Admin();
				ad.setUsername(rs.getString("username"));
				ad.setPassword(rs.getString("password"));
				return ad;
			}
		});	
		if(list.size()==1)
			return 1;
		else
			return -1;	
	}
	@Override
	public List<Donor> getDonor(String user) {
	 List<Donor> donor = template.query("select * from donor where donorName='"+user+"' ",  new RowMapper<Donor>() {
			@Override
			public Donor mapRow(ResultSet rs, int arg1) throws SQLException {	
				Donor d=new Donor();
				d.setDonerId(rs.getInt("donorId"));
				d.setDonarName(rs.getString("donorName"));
				d.setAge(rs.getInt("donorAge"));
				d.setContact(rs.getLong("contact"));
				d.setBloodgroup(rs.getString("bloodgroup"));
				return d;
			}
		});
	return donor;
	}

}
