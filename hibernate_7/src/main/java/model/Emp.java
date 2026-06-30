package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Emp {
	@Id
	private int empid;
	private String name;
	private String designation;
	@OneToMany
	private List<Acc>li=new ArrayList<>();
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Acc> getLi() {
		return li;
	}
	public void setLi(List<Acc> li) {
		this.li = li;
	}
	

}
