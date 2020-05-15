package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oli.authdemo.model.AuthAccount;

@Repository
public interface AuthAccountRepository extends JpaRepository<AuthAccount, Integer>{
	
	@Procedure("hr.credit")
	void depositMoney(@Param("ac_no")int acno, @Param("amount") double amount);
	
	@Procedure("hr.debit")
	void withdrawMoney(@Param("ac_no")int acno, @Param("amount") double amount);

}
