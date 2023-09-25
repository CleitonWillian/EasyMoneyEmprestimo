package br.com.easymoney.core.strategy.identifier.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNumeric;

import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.strategy.identifier.IdentifierValidationStrategy;

public class CNPJIdentifierValidation implements IdentifierValidationStrategy {

	@Override
	public ValidationDTO execute(String docIdentifier) {

		if (isEmpty(docIdentifier) || docIdentifier.length() != 14) {
			return ValidationDTO.from("CNPJ com quantidade de digitos irregular");
		}

		if (isNumeric(docIdentifier) && !docIdentifier.matches("(\\d)\\1+")) {
			int[] numbers = docIdentifier.chars().map(Character::getNumericValue).toArray();
		    if(!isCNPJ(numbers)) {
		    	return ValidationDTO.from("CNPJ inválido");
		    }
		}

		return ValidationDTO.ok();
	}

	private static boolean isCNPJ(int[] numbers) {
		int[] weights1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		int[] weights2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

		int firstDigit = calculateDigit(numbers, weights1);
		int secondDigit = calculateDigit(numbers, weights2);

		return numbers[12] == firstDigit && numbers[13] == secondDigit;
	}

	private static int calculateDigit(int[] numbers, int[] weights) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += numbers[i] * weights[i];
		}
		int remainder = sum % 11;
		return (remainder < 2) ? 0 : 11 - remainder;
	}

}
