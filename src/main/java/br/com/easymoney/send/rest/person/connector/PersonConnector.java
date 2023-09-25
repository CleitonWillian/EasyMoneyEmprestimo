package br.com.easymoney.send.rest.person.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.easymoney.send.rest.person.response.PersonReponseJson;

@FeignClient(name = "person-service", url = "http://localhost:8080/pessoas")
public interface PersonConnector {

	@GetMapping("/{id}")
	public PersonReponseJson find(@PathVariable String id);
	
}
