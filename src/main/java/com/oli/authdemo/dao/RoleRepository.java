package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oli.authdemo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
