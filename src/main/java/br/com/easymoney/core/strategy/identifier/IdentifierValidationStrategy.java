package br.com.easymoney.core.strategy.identifier;

import br.com.easymoney.core.dto.ValidationDTO;

public interface IdentifierValidationStrategy {

	ValidationDTO execute(String identifier);
}
