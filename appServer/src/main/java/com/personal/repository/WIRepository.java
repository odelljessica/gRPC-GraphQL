package com.personal.repository;

import com.personal.entities.WiringInstruction;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WIRepository extends JpaRepository<WiringInstruction, Integer> {}
