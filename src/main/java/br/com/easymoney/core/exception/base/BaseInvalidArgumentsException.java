package br.com.easymoney.core.exception.base;

import lombok.Getter;

@Getter
public class BaseInvalidArgumentsException  extends RuntimeException{

	private static final long serialVersionUID = 4929885780908065431L;
	private final String title ;;

	public BaseInvalidArgumentsException(String string) {
		super(string);
		this.title = "Argumento inválido";
	}
	
	public BaseInvalidArgumentsException(String title,String string) {
		super(string);
		this.title = title;
	}

}
