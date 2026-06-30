package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	private int did;
	private String dname;
	private String location;
	private int Reg_no;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getReg_no() {
		return Reg_no;
	}
	public void setReg_no(int reg_no) {
		Reg_no = reg_no;
	}
	


}
