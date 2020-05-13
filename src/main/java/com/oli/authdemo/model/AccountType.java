package com.oli.authdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ac_types", schema="hr")
public class AccountType {

	@Id
	@Column(name="AC_TYPE_ID")
	private int acTypeId;
	
	@Column(name="AC_TYPE_NAME")
	private String acTypeName;

	public int getAcTypeId() {
		return acTypeId;
	}

	public void setAcTypeId(int acTypeId) {
		this.acTypeId = acTypeId;
	}

	public String getAcTypeName() {
		return acTypeName;
	}

	public void setAcTypeName(String acTypeName) {
		this.acTypeName = acTypeName;
	}

	@Override
	public String toString() {
		return "AccountType [acTypeId=" + acTypeId + ", acTypeName=" + acTypeName + "]";
	}
	
	
}
