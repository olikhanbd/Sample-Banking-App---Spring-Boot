package com.oli.authdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auth_menu", schema="hr")
public class Menu {
	@Id
	@Column(name = "menu_id")
	@NotNull(message="Enter a valid id")
	private int id;

	@Column(name = "menu_name")
	@NotBlank(message="Enter a valid name")
	private String menuName;

	@Column(name = "menu_desc")
	private String desc;
	
	@Column(name = "menu_role")
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", desc=" + desc + ", roleName=" + roleName + "]";
	}

	
	
}
