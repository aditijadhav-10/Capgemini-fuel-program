package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	private int cid;
	private String cname;
	private String cadd;
	
    @ManyToMany
	private List<Product> p = new ArrayList<>();

	public Customer(int cid, String cname, String cadd) {
		this.cid = cid;
		this.cname = cname;
		this.cadd = cadd;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public List<Product> getP() {
		return p;
	}

	public void setP(List<Product> p) {
		this.p = p;
	}

}
