package br.com.easymoney.core.strategy.identifier.enums;

import br.com.easymoney.core.strategy.identifier.IdentifierValidationStrategy;
import br.com.easymoney.core.strategy.identifier.impl.CNPJIdentifierValidation;
import br.com.easymoney.core.strategy.identifier.impl.CPFIdentifierValidation;
import br.com.easymoney.core.strategy.identifier.impl.RetireeIdentifierValidation;
import br.com.easymoney.core.strategy.identifier.impl.StudantIdentifierValidation;
import lombok.Getter;

@Getter
public enum IdentifierStrategyPersonType {

	PF(new CPFIdentifierValidation()),
	PJ( new CNPJIdentifierValidation()),
	EU( new StudantIdentifierValidation()),
	AP(new RetireeIdentifierValidation());

	private IdentifierValidationStrategy validation;

	IdentifierStrategyPersonType(IdentifierValidationStrategy validation) {
		this.validation = validation;
		
	}
	
}
