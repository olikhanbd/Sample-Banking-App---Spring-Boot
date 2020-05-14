package com.oli.authdemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "auth_role", schema="hr")
public class Role {
	@Id
	@Column(name = "auth_role_id")
	@NotNull(message="Enter a valid id")
	private int id;

	@Column(name = "role_name")
	@NotBlank(message="Enter a valid name")
	private String roleName;

	@Column(name = "role_desc")
	private String desc;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	@JsonManagedReference
    private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", desc=" + desc + ", users=" + users + "]";
	}
	
	
	
	

}
