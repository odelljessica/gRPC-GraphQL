package com.personal.datafetcher;

import com.personal.entities.Bank;
import com.personal.entities.WiringInstruction;
import com.personal.repository.BankRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankFetcher {

    @Autowired
    private BankRepository bankRepository;

    public DataFetcher<Bank> getBankForWiringInstruction() {
        return dataFetchingEnvironment -> {
            WiringInstruction wiringInstruction = dataFetchingEnvironment.getSource();
            return this.bankRepository.getOne(wiringInstruction.getBankId());
        };
    }

}
