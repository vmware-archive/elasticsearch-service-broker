package io.pivotal.ecosystem.service.client;

import io.pivotal.cf.broker.es.ElasticSearchRepository;
import io.searchbox.client.JestResult;
import io.searchbox.indices.aliases.GetAliases;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ClientController {

    private ElasticSearchRepository repo;

    public ClientController(ElasticSearchRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    ResponseEntity<String> getIndexes() throws IOException {
        GetAliases aliases = new GetAliases.
                Builder().
                build();

        JestResult result = repo.client().execute(aliases);
        String json = result.getJsonString();

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
