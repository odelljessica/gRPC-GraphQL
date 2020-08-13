package com.personal.service;

import com.personal.datafetcher.BankFetcher;
import com.personal.datafetcher.ProductDataFetcher;
import com.personal.datafetcher.WIDataFetcher;
import graphql.GraphQL;
import graphql.GraphQL.Builder;
import graphql.execution.instrumentation.Instrumentation;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQLService.class);

    @Value("classpath:schema.graphql")
    Resource resource;

    private Builder graphQL;

    @Autowired
    private WIDataFetcher wiringInstructionsDataFetcher;

    @Autowired
    private BankFetcher bankDataFetcher;

    @Autowired
    private ProductDataFetcher productDataFetcher;

    // load schema at app start up
    @PostConstruct
    public void loadSchema() throws IOException {

        // get the schema file (named "schemaFile")
        File schemaFile = this.resource.getFile();

        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile); // keeps track of existing/requested objects
        RuntimeWiring wiring = this.buildWiring(); // perform wiring
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring); // provide wiring to GraphQL schema and make it executable
        this.graphQL = GraphQL.newGraphQL(schema); // build as GraphQL API
    }

    // wires data fetchers
    private RuntimeWiring buildWiring() { // check fetchers to revise this
        return RuntimeWiring.newRuntimeWiring()
            .type("Query", this::dataFetcherWiringInstruction)
            .type("WiringInstruction", wiring -> wiring
                .dataFetcher("bank", this.bankDataFetcher.getBankForWiringInstruction()) // Nested Entity in WI
                .dataFetcher("products", this.productDataFetcher)) // Nested Entity in WI
            //.type("Mutation", this::mutationDebug)
            .build();
    }

    /**
     * First entry point of Queries
     *
     * @param typeWiring
     * @return
     */
    public TypeRuntimeWiring.Builder dataFetcherWiringInstruction(TypeRuntimeWiring.Builder typeWiring) {
        return typeWiring
            .dataFetcher("getWiringInstruction", this.wiringInstructionsDataFetcher.getWiById())
            .dataFetcher("getWiringInstructions", this.wiringInstructionsDataFetcher.getAllWiDataFetcher());
    }

    public TypeRuntimeWiring.Builder mutationDebug(TypeRuntimeWiring.Builder typeWiring) {
        LOGGER.info("Reaching the mutationDebug");
        return null;
    }

    public GraphQL getGraphQL() {
        return this.graphQL.build();
    }

    public GraphQL getGraphQL(Instrumentation instrumentation) {
        return this.graphQL.instrumentation(instrumentation).build();
    }

}
