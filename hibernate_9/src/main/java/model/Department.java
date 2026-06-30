package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int did;
	private String dname;

	@OneToMany
	private List<Emplyee> e = new ArrayList<Emplyee>();

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

	public List<Emplyee> getE() {
		return e;
	}

	public void setE(List<Emplyee> e) {
		this.e = e;
	}

}
