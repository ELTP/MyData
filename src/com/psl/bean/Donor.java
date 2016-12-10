package com.psl.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component(value="donor")
public class Donor {
	@NotNull
	private int donerId;
	@Size(min=2,max=30, message="Not valid Name")
	private String donarName;
	@Min(18)
	private int age;
	@NotNull
	private long contact;
    @NotNull
	private String bloodgroup;

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public int getDonerId() {
		return donerId;
	}

	public void setDonerId(int donerId) {
		this.donerId = donerId;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

}
