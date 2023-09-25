package br.com.easymoney.core.bussineslogic;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.command.PersonValidationCommand;
import br.com.easymoney.core.dto.PersonType;
import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.strategy.identifier.enums.IdentifierStrategyPersonType;
import br.com.easymoney.core.usecase.PersonValidationUseCase;

@Service
public class PersonValidationUseCaseImpl implements PersonValidationUseCase {

	@Override
	public ValidationDTO process(PersonValidationCommand command) {

		return Optional.ofNullable(command.type())
				.map(PersonType::name)
				.map(IdentifierStrategyPersonType::valueOf)
				.map(identifierValidationStrategyType -> 
					identifierValidationStrategyType.getValidation()
						.execute(command.docIdentifier()))
				.orElse(ValidationDTO.from("Erro ao tentar processo de validação da pessoa"));

	}

}
