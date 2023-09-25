package br.com.easymoney.send.rest.person.mapper;

import org.springframework.stereotype.Component;

import br.com.easymoney.core.dto.LoanConditionsDTO;
import br.com.easymoney.core.dto.PersonDTO;
import br.com.easymoney.core.dto.PersonType;
import br.com.easymoney.core.exception.client.PersonValidationException;
import br.com.easymoney.send.rest.person.response.PersonReponseJson;

@Component
public class PersonSendRestMapper {

	  public PersonDTO from(PersonReponseJson personReponseJson) {
	        var personType = PersonType.findByLabel(personReponseJson.getType())
	                                          .orElseThrow(() -> new PersonValidationException("A aplicação na trabalha com esse tipo de pessoa " + personReponseJson.getType() + "."));

	        return new PersonDTO(
	            personReponseJson.getId(),
	            personReponseJson.getDocIdentifier(),
	            personType,
	            new LoanConditionsDTO(
	                personReponseJson.getLoanConditions().getMinInstallmentAmount(),
	                personReponseJson.getLoanConditions().getMaxTotalAmount()
	            )
	        );
	    }

}
