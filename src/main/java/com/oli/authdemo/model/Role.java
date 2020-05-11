package com.oli.authdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auth_role")
public class Role {
	@Id
	@Column(name = "auth_role_id")
	@NotNull(message="Enter a valid id")
	private int id;

	@Column(name = "role_name")
	@NotBlank(message="Enter a valid first name")
	private String role;

	@Column(name = "role_desc")
	private String desc;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", desc=" + desc + "]";
	}
	
	

}
