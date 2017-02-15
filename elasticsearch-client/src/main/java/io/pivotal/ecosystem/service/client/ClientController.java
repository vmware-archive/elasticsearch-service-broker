/**
 * Copyright (C) 2017-Present Pivotal Software, Inc. All rights reserved.
 * <p>
 * This program and the accompanying materials are made available under
 * the terms of the under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * <p>
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * <p>
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
