package com.personal.datafetcher;

import com.personal.entities.Product;
import com.personal.entities.WiringInstruction;
import com.personal.repository.ProductRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDataFetcher implements DataFetcher<List<Product>> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> get(DataFetchingEnvironment env) {
        WiringInstruction wi = env.getSource();
        return this.productRepository.findByWiringInstruction(wi);
    }
}
