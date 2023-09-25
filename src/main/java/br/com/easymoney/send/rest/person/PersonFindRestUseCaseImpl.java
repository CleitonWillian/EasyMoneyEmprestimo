package br.com.easymoney.send.rest.person;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.usecase.PersonFindUseCase;
import br.com.easymoney.send.rest.person.connector.PersonConnector;
import br.com.easymoney.send.rest.person.mapper.PersonSendRestMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonFindRestUseCaseImpl implements PersonFindUseCase{

	private final PersonConnector connector;
	
	private final PersonSendRestMapper mapper;
	
	@Override
	public PersonDTO process(String id) {
		
		var personReponseJson = connector.find(id);
		
		var person = mapper.from(personReponseJson);
		
		return person;
	}

}
