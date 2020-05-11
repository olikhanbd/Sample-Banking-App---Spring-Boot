package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oli.authdemo.model.Employee;
import com.oli.authdemo.model.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
