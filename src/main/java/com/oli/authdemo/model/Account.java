package com.oli.authdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="account", schema="hr")
public class Account {

	@Id
	@Column(name="ac_no")
	@NotNull(message="Enter a valid account number")
	private int acNumber;
	
	@Column(name="customer_name")
	@NotBlank(message="Enter a valid name")
	private String customerName;
	
	@NotBlank(message="Enter a valid name")
	@Column(name="fathers_name")
	private String fathersName;
	
	@Column(name="mothers_name")
	@NotBlank(message="Enter a valid name")
	private String mothersName;
	
	@Column(name="dob")
	@NotBlank(message="Enter a valid date")
	private String dob;
	
	@Column(name="address")
	@NotBlank(message="Enter a valid address")
	private String address;
	
	@Column(name="nid")
	@NotNull(message="Enter a valid nid number")
	private int nid;
	
	@Column(name="phoneno")
	@NotNull(message="Enter a valid phone number")
	private int phoneNo;
	
	@Column(name="ac_type")
	private String acType;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="nid_photo")
	private String nidPhoto;

	public int getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(int acNumber) {
		this.acNumber = acNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
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

	@Override
	public String toString() {
		return "Account [acNumber=" + acNumber + ", customerName=" + customerName + ", fathersName=" + fathersName
				+ ", mothersName=" + mothersName + ", dob=" + dob + ", address=" + address + ", nid=" + nid
				+ ", phoneNo=" + phoneNo + ", acType=" + acType + ", photo=" + photo + ", nidPhoto=" + nidPhoto + "]";
	}

	
	
	
}
