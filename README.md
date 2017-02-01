#Elasticsearch Simple Broker

Elasticsearch Simple Broker is provide a minimum viable project to allow Cloud Foundry operators to publish the presence of Elasticsearch in their Cloud Foundry marketplace. The broker can broadcast Elasticsearch credentails hosted either by a public cloud provider, such as Amazon Web Service or Google Cloud, as well as  deployments of Elasticsearch in the private-cloud, to include Open-Source Elasticsearch clusters deployed by BOSH.

The project is made of several modues to assist in the deployment, configuration, and testing of this broker. 

[##elasticsearch-service-broker](elasticsearch-service-broker/tree/master/elasticsearch-service-broker)
This is the main broker, written as a Spring Boot Application in Java. 

[##elasticsearch-connector](elasticsearch-service-broker/tree/master/elasticsearch-connector)
This is a spring cloud service connector that simplifies how other Spring Boot applications can easily connect to elasticsearch service without parsing connections details from the environment variables. 

[##elasticsearch-client](elasticsearch-service-broker/tree/master/elasticsearch-client)
A simple spring-boot application that can be used to test the successful deployment of elastic-search-broker and validate its functionality. 

To deploy the broker

