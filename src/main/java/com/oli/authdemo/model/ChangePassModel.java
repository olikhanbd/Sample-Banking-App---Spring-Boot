package com.oli.authdemo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePassModel {

	@NotBlank
	private String oldPass;
	
	@NotBlank
	private String newPass;

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	@Override
	public String toString() {
		return "ChangePassModel [oldPass=" + oldPass + ", newPass=" + newPass + "]";
	}
	
	
}
