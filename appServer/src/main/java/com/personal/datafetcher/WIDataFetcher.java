package com.personal.datafetcher;

import com.personal.entities.WiringInstruction;
import com.personal.repository.WIRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WIDataFetcher {

    @Autowired
    private WIRepository wiRepository;

    public DataFetcher<WiringInstruction> getWiById() {
        return dataFetchingEnvironment -> {
            Integer id = dataFetchingEnvironment.getArgument("id");
            return this.wiRepository.getOne(id);
        };

        //return new DataFetcher<WiringInstruction>() {
        //    @Override
        //    public WiringInstruction get(DataFetchingEnvironment dataFetchingEnvironment) {
        //        Integer id = dataFetchingEnvironment.getArgument("id");
        //        return WIDataFetcher.this.wiRepository.getOne(id);
        //    }
        //};
    }

    public DataFetcher<List<WiringInstruction>> getAllWiDataFetcher() {
        return dataFetchingEnvironment -> this.wiRepository.findAll(PageRequest.of(0, 50)).getContent();

        //return new DataFetcher<List<WiringInstruction>>() {
        //    @Override
        //    public List<WiringInstruction> get(DataFetchingEnvironment dataFetchingEnvironment) {
        //        return WIDataFetcher.this.wiRepository.findAll(PageRequest.of(0, 50)).getContent();
        //    }
        //};
    }
}
