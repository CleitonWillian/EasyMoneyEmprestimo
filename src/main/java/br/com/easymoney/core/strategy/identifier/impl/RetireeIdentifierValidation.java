package br.com.easymoney.core.strategy.identifier.impl;

import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.length;

import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.strategy.identifier.IdentifierValidationStrategy;

public class RetireeIdentifierValidation implements IdentifierValidationStrategy {

	@Override
	public ValidationDTO execute(String identifier) {
		if (length(identifier) != 10 || !isNumeric(identifier))
			return ValidationDTO.from("Documentação do Aposentado esta inválida, precisa ter digitos somente numéricos e validos");

		char lastDigit = identifier.charAt(9);
		int count = countMatches(identifier, lastDigit);

		if( count != 1) {
			return ValidationDTO.from("Documentação do Aposentado esta inválida");
		};
		
		return ValidationDTO.ok();
	}
	
}
