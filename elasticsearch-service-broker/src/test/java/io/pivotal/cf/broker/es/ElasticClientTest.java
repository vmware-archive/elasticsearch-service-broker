/**
 Copyright (C) 2016-Present Pivotal Software, Inc. All rights reserved.

 This program and the accompanying materials are made available under
 the terms of the under the Apache License, Version 2.0 (the "License”);
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package io.pivotal.cf.broker.es;

import io.searchbox.client.JestClient;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ElasticClientTest {

    @Autowired
    private JestClient client;

    @Test
    public void testConnection() throws IOException {
        boolean indexExists = client.execute(new IndicesExists.Builder("foo").build()).isSucceeded();
        if (indexExists) {
            client.execute(new DeleteIndex.Builder("foo").build());
        }
        client.execute(new CreateIndex.Builder("foo").build());
    }
    
    @Test
    public void testCatalogConnection() throws Exception {
    	
    }
}