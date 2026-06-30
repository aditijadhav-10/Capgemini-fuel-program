package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private int price;
	@ManyToMany
	private List<Customer> c = new ArrayList<Customer>();

	public Product(int pid, String pname, int price) {
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Customer> getC() {
		return c;
	}

	public void setC(List<Customer> c) {
		this.c = c;
	}


}
