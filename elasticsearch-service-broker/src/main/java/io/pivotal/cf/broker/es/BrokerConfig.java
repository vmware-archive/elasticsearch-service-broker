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
import io.searchbox.client.config.HttpClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@Slf4j
public class BrokerConfig {

    @Autowired
    Environment env;

    @Bean
    JestClient client() {
        JestClientFactory factory = new JestClientFactory();
        String connection = "http://" + env.getProperty("ELASTIC_HOST") + ":" + env.getProperty("ELASTIC_PORT");
        log.info("connecting to elastic service at " + connection);
        factory.setHttpClientConfig(new HttpClientConfig.Builder(connection).multiThreaded(true).build());
        return factory.getObject();
    }
}