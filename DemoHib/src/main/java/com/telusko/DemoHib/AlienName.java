package com.telusko.DemoHib;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	@Override
	public String toString() {
		return "AlienName [Fname=" + Fname + ", Mname=" + Mname + ", Lname=" + Lname + "]";
	}
	public String Fname;
	public String Mname;
	public String Lname;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}

}
