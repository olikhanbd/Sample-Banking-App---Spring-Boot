package com.oli.authdemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="customer", schema = "hr")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="mname")
	private String mname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phoneno")
	private int phoneno;
	
	@Column(name="nid")
	private int nid;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="nidPhoto")
	private String nidPhoto;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@JsonManagedReference
    private List<AuthAccount> accounts;

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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNidPhoto() {
		return nidPhoto;
	}

	public void setNidPhoto(String nidPhoto) {
		this.nidPhoto = nidPhoto;
	}

	public List<AuthAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AuthAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", dob=" + dob + ", fname=" + fname + ", mname=" + mname
				+ ", address=" + address + ", phoneno=" + phoneno + ", nid=" + nid + ", photo=" + photo + ", nidPhoto="
				+ nidPhoto + ", accounts=" + accounts + "]";
	}
	
	

}
