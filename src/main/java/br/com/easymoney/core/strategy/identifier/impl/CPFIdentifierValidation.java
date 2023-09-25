package br.com.easymoney.core.strategy.identifier.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNumeric;

import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.strategy.identifier.IdentifierValidationStrategy;

public class CPFIdentifierValidation implements IdentifierValidationStrategy {

	@Override
	public ValidationDTO execute(String docIdentifier) {
		
        if (isEmpty(docIdentifier) || docIdentifier.length() != 11 || !isNumeric(docIdentifier)) {
        	return ValidationDTO.from("CPF não passou pela validação numérica");
        }

        int[] numbers = docIdentifier.chars().map(Character::getNumericValue).toArray();
         if(!isCpf(numbers)) {
        	 return ValidationDTO.from("CPF inválido");
         };
         
         return ValidationDTO.ok();
    }

    private boolean isCpf(int[] numbers) {
        int firstDigit = calculateVerificationDigit(numbers, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2});
        int secondDigit = calculateVerificationDigit(numbers, new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2});

        return numbers[9] == firstDigit && numbers[10] == secondDigit;
    }

    private int calculateVerificationDigit(int[] digits, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += digits[i] * weights[i];
        }
        int mod = sum % 11;
        return (mod < 2) ? 0 : 11 - mod;
    }

}
