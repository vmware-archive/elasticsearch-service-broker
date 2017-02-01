#elastic-search-broker
Broker allows connecting Cloud Foundry apps to a hosted elasticsearch service. 

##Prerequisites
1. The broker requires a redis datastore. To set this up:
  
  ```bash
  cf create-service p-redis shared-vm redis-elastic
  ```
2. The broker makes use of spring-security to protect itself against unauthorized meddling. To set its password edit the [src/main/resources/application.properties file](src/main/resources/application.properties) and [src/test/resources/application.properties](src/test/resources/application.properties)

3. Build the broker from the root directory of the project:
  ```bash
  mvn clean install
  cd elasticsearch-service-broker
  ```
4. Edit the [manifest.yml](manifest.yml) file to provide Elasticsearch Hostname and Port. You may also need to change the API version to match your CF environment. 

7. Push the broker to cf:
  
  ```bash
  cf push
  ```
8. Register the broker:
  
  ```bash
  cf create-service-broker elasticsearch-broker user the_password_from_application_properties https://<uri.of.your.broker.app>
  ```
9. See the broker:
  
  ```bash
  cf service-brokers
  Getting service brokers as admin...
  
  name                          url
  ...
  elasticsearch                  https://your-broker-url
  ...
  
  cf service-access
  Getting service access as admin...
  ...
  broker: 
     service           plan         access   orgs
     elasticsearch     standard     none
  ...
  
  cf enable-service-access elasticsearch
  Enabling access to all plans of service hello for all orgs as admin...

  cf marketplace
  Getting services from marketplace in org your-org / space your-space as you...
  OK
  
  service                 plans                                 description
  elasticsearch           standard                              Elasticsearch service for CF Apps
  ...
  ```
10. Create an service instance of elasticsearch:
  
  ```bash
  cf create-service elasticsearch standard elastic-test-service
  ```
11. Look at the broker logs:
  
  ```bash
  cf logs esbroker --recent
  ...
  2016-10-07T10:30:27.16-0400 [APP/0]      OUT 2016-10-07 14:30:27 [http-nio-8080-exec-7] INFO  i.p.c.s.service.InstanceService - creating service instance: 727b9a....
  ...