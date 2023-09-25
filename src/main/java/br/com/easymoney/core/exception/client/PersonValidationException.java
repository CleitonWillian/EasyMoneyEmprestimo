package br.com.easymoney.core.exception.client;

import br.com.easymoney.core.exception.base.BaseInvalidArgumentsException;

public class PersonValidationException extends BaseInvalidArgumentsException {

	private static final long serialVersionUID = 1L;

	public PersonValidationException(String string) {
		super("Validação da documentação",string);
	}

}

