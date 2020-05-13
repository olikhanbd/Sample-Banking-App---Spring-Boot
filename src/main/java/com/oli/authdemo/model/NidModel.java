package com.oli.authdemo.model;

import org.springframework.web.multipart.MultipartFile;

public class NidModel {

	private MultipartFile nid;
	
	private int acno;

	public MultipartFile getNid() {
		return nid;
	}

	public void setNid(MultipartFile nid) {
		this.nid = nid;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	@Override
	public String toString() {
		return "NidModel [nid=" + nid + ", acno=" + acno + "]";
	}

	
	
}
