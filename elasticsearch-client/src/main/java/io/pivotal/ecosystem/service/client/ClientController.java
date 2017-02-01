package io.pivotal.ecosystem.service.client;

import io.pivotal.cf.broker.es.ElasticSearchRepository; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController<ElasticServiceBroker> {
	
	private ElasticSearchRepository repo; 
	
	public ClientController(ElasticSearchRepository repo){
		this.repo = repo; 
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	ResponseEntity<String> getIndex(@RequestParam String index){
		repo.
		try{
			return new ResponseEntity<>(repo..., HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), e.getStackTrace());
		}
	}
}
