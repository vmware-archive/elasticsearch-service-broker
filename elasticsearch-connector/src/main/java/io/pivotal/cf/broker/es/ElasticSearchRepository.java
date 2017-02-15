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

package io.pivotal.cf.broker.es;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.indices.aliases.GetAliases;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@Slf4j
public class ElasticSearchRepository {

    private ElasticSearchServiceInfo info;


    public ElasticSearchRepository(ElasticSearchServiceInfo info) {
        this.info = info;
    }

    @Bean
    public JestClient client() {
        JestClientFactory factory = new JestClientFactory();
        String connection = "http://" + info.getHost() + ":" + info.getPort();
        factory.setHttpClientConfig(new HttpClientConfig.Builder(connection).multiThreaded(true).build());
        return factory.getObject();
    }

    public String getIndexes() throws IOException {
        GetAliases aliases = new GetAliases.
                Builder().
                build();

        JestResult result = client().execute(aliases);
        String json = result.getJsonString();
        return json;
    }

}