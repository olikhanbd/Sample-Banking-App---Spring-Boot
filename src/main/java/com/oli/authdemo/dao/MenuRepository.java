package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oli.authdemo.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
