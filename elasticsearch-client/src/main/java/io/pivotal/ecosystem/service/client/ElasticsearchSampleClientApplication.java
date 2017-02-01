package io.pivotal.ecosystem.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.java.ServiceScan;

@SpringBootApplication
@ServiceScan
public class ElasticsearchSampleClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchSampleClientApplication.class, args);
	}
}
