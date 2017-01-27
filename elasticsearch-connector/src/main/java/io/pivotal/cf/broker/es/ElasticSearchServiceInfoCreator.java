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

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

@Slf4j
public class ElasticSearchServiceInfoCreator extends CloudFoundryServiceInfoCreator<ElasticSearchServiceInfo> {

    public ElasticSearchServiceInfoCreator() {
        super(new Tags(ElasticSearchServiceInfo.URI_SCHEME), ElasticSearchServiceInfo.URI_SCHEME);
    }

    @Override
    public ElasticSearchServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        log.info("Returning elasticSearch service info: " + serviceData.toString());

        Map<String, Object> credentials = getCredentials(serviceData);
        String id = getId(serviceData);
        String host = credentials.get("hostname").toString();
        String port = credentials.get("port").toString();
        String uri = credentials.get("uri").toString();

        return new ElasticSearchServiceInfo(id, host, port, uri);
    }
}