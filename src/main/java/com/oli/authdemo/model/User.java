package com.oli.authdemo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "AUTH_USER", schema="hr")
public class User {

	@Id
	@Column(name = "AUTH_USER_ID")
	@NotNull(message="Enter a valid user id")
	private int id;

	@Column(name = "FIRST_NAME")
	@NotBlank(message="Enter a valid first name")
	private String name;

	@Column(name = "LAST_NAME")
	@NotBlank(message="Enter a valid last name")
	private String lastName;

	@Column(name = "EMAIL")
	@NotEmpty(message="Enter a valid email")
	@Email(message="Enter a valid email")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "STATUS")
	private String status;

//	@Column(name = "USER_ROLE")
//	private int roleId;
	 

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auth_role_id")
	@JsonBackReference
    private Role role;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


//	public int getRoleId() {
//		return roleId;
//	}


//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", status=" + status + ", role=" + role.getRoleName() + "]";
	}


	
	
	
	

}

