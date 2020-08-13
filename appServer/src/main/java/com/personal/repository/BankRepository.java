package com.personal.repository;

import com.personal.entities.Bank;
import com.personal.entities.WiringInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
}
