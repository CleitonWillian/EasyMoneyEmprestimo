package br.com.easymoney.core.strategy.identifier.impl;

import static java.lang.Character.getNumericValue;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.length;

import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.strategy.identifier.IdentifierValidationStrategy;

public class StudantIdentifierValidation implements IdentifierValidationStrategy {

	@Override
	public ValidationDTO execute(String identifier) {
		if (length(identifier) != 8 || !isNumeric(identifier))
			return ValidationDTO.from("Documentação do Estudante esta inválida, precisa ter digitos somente numéricos e validos");

		int firstDigit = getNumericValue(identifier.charAt(0));
		int lastDigit = getNumericValue(identifier.charAt(7));

		if( firstDigit + lastDigit != 9) {
			return ValidationDTO.from("Documentação do Estudante esta inválida");
		};
		
		return ValidationDTO.ok();
		
	}

}
