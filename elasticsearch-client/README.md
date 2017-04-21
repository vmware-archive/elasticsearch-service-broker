# elasticsearch-client 
A simple elasticsearch client application to test the elasticserach service available in cloud foundry marketplace.

1. Change directory to elasticsearch-client from the root directory. 
 ```bash
 cd elasticsearch-client
  ```

2. Deploy the app to cf. Make sure you have provisioned an instance of elasticsearch service with the name 'elastic-test-service' before pushing the app to cf. 
  ```bash
  cf push
  ```

3. Confirm credentials are accessible to the app from its environment.
  
  ```bash
  cf env elasticsearch-client
  ...
  ```
  ```json
	{
	 "VCAP_SERVICES": {
	  "elasticsearch": [
	   {
	    "credentials": {
	     "host": "...",
	     "indexName": "caa32964-...",
	     "port": "9200",
	     "uri": "http://...:9200/caa32964-..."
	    },
	    "label": "elasticsearch",
	    "name": "elastic-test-service",
	    "plan": "standard",
	    "provider": null,
	    "syslog_drain_url": null,
	    "tags": [
	     "elasticsearch"
	    ],
	    "volume_mounts": []
	   }
	  ]
	 }
	}
  ```
4. Unbind your app from the service and clean up. 
  
  ```bash
  cf unbind-service elasticsearch-client elastic-test-service
  cf delete-service elastic-test-service -f
  cf delete elasticsearch-client -f
  ``` 

