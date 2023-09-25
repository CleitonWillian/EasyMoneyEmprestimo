package br.com.easymoney.core.exception.client;

import br.com.easymoney.core.exception.base.BaseInvalidArgumentsException;

public class LoanValidationException extends BaseInvalidArgumentsException {

	private static final long serialVersionUID = 1L;

	public LoanValidationException(String string) {
		super("Validação das condições de emprestimo",string);
	}

}

