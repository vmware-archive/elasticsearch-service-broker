#Elasticsearch Simple Broker

Elasticsearch Simple Broker is a minimum viable project to allow Cloud Foundry operators to publish the presence of Elasticsearch offered as a service in their Cloud Foundry marketplace. The broker is compatible with multiple version of Elasticsearch (2+, 5+). It can be used to publish access credentials from a managed offering of Elasticsearch available from a public cloud provider, such as Amazon Web Service, as well as  deployments of Elasticsearch in the private-cloud, to include Open-Source Elasticsearch clusters deployed by BOSH. This version of broker allow apps to can connect to the elasticsearch service over HTTP protocol only. 

The project is made of several modues to assist in the deployment, configuration, and testing of this broker. 

##[elasticsearch-service-broker](elasticsearch-service-broker)
This is the main broker, written as a Spring Boot Application in Java.  
**Step 1:** Deploy the broker. Directions are provided in this repository.

##[elasticsearch-client](elasticsearch-client)
A spring-boot application to test the successful deployment of elastic-search-broker and validate its functionality.  
**Step 2:** Test the broker with this client. Directions are provided in this repository.

##[elasticsearch-connector](elasticsearch-connector)
This is a spring cloud service connector that simplifies how other Spring Boot applications can easily connect to elasticsearch service without parsing connections details from the environment variables.


