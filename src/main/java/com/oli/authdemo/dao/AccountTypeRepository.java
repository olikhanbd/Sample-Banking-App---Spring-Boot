package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oli.authdemo.model.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer>{

}
