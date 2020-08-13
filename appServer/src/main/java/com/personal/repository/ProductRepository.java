package com.personal.repository;

import com.personal.entities.Product;
import com.personal.entities.WiringInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // select p.intProductID, p.varDescription, p.intValue from tsjDirProductWiringInstructions pwi left join tblProducts p on p.intProductID = pwi.intProductID where pwi.intWiringInstructionsID = 24
    //@Query("SELECT wp.productID, wp.description, wp.value FROM WiringInstructionJoinProduct wp WHERE wi.wiringInstructionID = ?1")
    //public abstract Optional<WIProductJoin> findByWiringInstructionID(int id);

    List<Product> findByWiringInstruction(WiringInstruction wiringInstructionsID);
}
