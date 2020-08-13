package com.personal.resource;

import com.personal.service.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposing HTTP Endpoint that receives HTTP:POST GraphQL Requests.
 * Endpoint: /quasar/wi
 */
@RequestMapping("/quasar")
@RestController
public class QuasarExtractorController {

    @Autowired
    private GraphQLService graphQLService;

    /**
     * HTTP GraphQL Endpoint that can receive Query and Mutation requests
     *
     * @param query
     * @param <T>
     * @return
     */
    @PostMapping("/wi")
    public <T> T getWiringInstructions(@RequestBody String query) {
        return this.graphQLService.getGraphQL().execute(query).getData();
    }

}
