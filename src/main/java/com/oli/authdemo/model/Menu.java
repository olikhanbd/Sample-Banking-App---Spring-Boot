package com.oli.authdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auth_menu")
public class Menu {
	@Id
	@Column(name = "menu_id")
	@NotNull(message="Enter a valid id")
	private int id;

	@Column(name = "menu_name")
	@NotBlank(message="Enter a valid name")
	private String menu;

	@Column(name = "menu_desc")
	private String desc;
	
	@Column(name = "menu_role")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menu=" + menu + ", desc=" + desc + ", role=" + role + "]";
	}

	
	
	
}
