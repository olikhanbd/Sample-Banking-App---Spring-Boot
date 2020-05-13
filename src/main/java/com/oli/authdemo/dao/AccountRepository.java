package com.oli.authdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oli.authdemo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
