package br.com.easymoney.core.exception.client;

import br.com.easymoney.core.exception.base.BaseNotFoundException;

public class LoanNotFoundException extends BaseNotFoundException{

	private static final long serialVersionUID = 1L;

	public LoanNotFoundException() {
		super("Empréstimo não encontrado");
	}

}

