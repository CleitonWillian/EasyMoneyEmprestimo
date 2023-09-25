package br.com.easymoney.core.bussineslogic;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.command.LoanConditionsValidationCommand;
import br.com.easymoney.core.command.LoanMakeCommand;
import br.com.easymoney.core.command.LoanSaveCommand;
import br.com.easymoney.core.command.PersonValidationCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.core.exception.client.LoanValidationException;
import br.com.easymoney.core.exception.client.PersonValidationException;
import br.com.easymoney.core.usecase.LoanConditionsValidationUseCase;
import br.com.easymoney.core.usecase.LoanMakeUseCase;
import br.com.easymoney.core.usecase.LoanSaveUseCase;
import br.com.easymoney.core.usecase.PaymentMakeUseCase;
import br.com.easymoney.core.usecase.PersonFindUseCase;
import br.com.easymoney.core.usecase.PersonValidationUseCase;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanMakeUseCaseIpml implements LoanMakeUseCase {

	private final PersonFindUseCase personFindUseCase;
	
	private final PersonValidationUseCase personValidationUseCase; 
	
	private final LoanConditionsValidationUseCase loanConditionsValidationUseCase;
	
	private final PaymentMakeUseCase paymentMakeUseCase;
	
	private final LoanSaveUseCase loanSaveUseCase;
	
	public LoanDTO process(LoanMakeCommand command) {
		
		var person = personFindUseCase.process(command.personId());
		
		var	personValidation = personValidationUseCase.process(new PersonValidationCommand(person.id(), person.docIdentifier(), person.type()));
				
		personValidation.ifUnsuccessfulThrow(() -> new PersonValidationException(personValidation.messages().stream().collect(joining(lineSeparator()))));
		
		var loanValidation = loanConditionsValidationUseCase.process(new LoanConditionsValidationCommand(
				person.type(), 
				command.installmentQuantiy() , 
				command.installmentValue(),
				person.loandConditions()));
		
		loanValidation.ifUnsuccessfulThrow(() -> new LoanValidationException(loanValidation.messages().stream().collect(joining(lineSeparator()))));
		
		var lean = loanSaveUseCase.process(new LoanSaveCommand(person.id(), command.installmentQuantiy(), command.installmentValue()));
		
		paymentMakeUseCase.process(lean.id());
		
		return lean;
	}

}
