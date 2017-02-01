#elastic-search-broker
Broker allows connecting Cloud Foundry apps to a hosted elasticsearch service. 

##Prerequisites
1. The broker makes use of spring-security to protect itself against unauthorized meddling. To set its password edit the [src/main/resources/application.properties file](src/main/resources/application.properties).

2. Edit the [src/test/resources/application.properties](src/test/resources/application.properties) to provide Elasticsearch hostname and port specific to your environment. 

3. Build the broker from the root directory of the project. It will also run some tests.
  ```bash
  mvn clean install
  cd elasticsearch-service-broker
  ```

##Deploy & Register Broker to Cloud Foundry Marketplace

1. Edit the [manifest.yml](manifest.yml) file to provide Elasticsearch Hostname and Port. You may also need to change the API version to match your CF environment. 

2. Create an instance of a redis service.
 
  ```bash
  cf create-service p-redis shared-vm redis-elastic
  ```

3. Push the broker to cf:
  
  ```bash
  cf push
  ```
4. Register the broker:
  
  ```bash
  cf create-service-broker elasticsearch-broker user the_password_from_application_properties https://<uri.of.your.broker.app>
  ```
5. See the broker:
  
  ```bash
  cf service-brokers
  Getting service brokers as admin...
  
  name                          url
  ...
  elasticsearch-broker          https://your-broker-url
  ...
  
  cf service-access
  Getting service access as admin...
  ...
  broker: elasticsearch-broker
     service         plan       access   orgs
     elasticsearch   standard   none
  ...

  cf enable-service-access elasticsearch
  Enabling access to all plans of service elasticsearch for all orgs as admin...

  cf marketplace
  Getting services from marketplace in org your-org / space your-space as you...
  OK
  
  service                 plans                                 description
  elasticsearch           standard                              Elasticsearch service for PCF
  ...
  ```
6. Create an service instance of elasticsearch:
  
  ```bash
  cf create-service elasticsearch standard elastic-test-service
  ```
7. Look at the broker logs:
  
  ```bash
  cf logs esbroker --recent
  ...
  2017-02-01T17:18:00.45-0500 [APP/PROC/WEB/0]OUT 2017-02-01 22:18:00 [http-nio-8080-exec-6] INFO  i.p.e.s.service.InstanceService - creating service instance: caa32964-e75d-4bfb-b78d-28456a40c524 service definition: p-elastic
  ...
