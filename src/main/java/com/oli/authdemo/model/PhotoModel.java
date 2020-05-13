package com.oli.authdemo.model;
import org.springframework.web.multipart.MultipartFile;
public class PhotoModel {

	private MultipartFile photo;
	
	private int acno;

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	@Override
	public String toString() {
		return "PhotoModel [photo=" + photo + ", acno=" + acno + "]";
	}

	
	
	
}
