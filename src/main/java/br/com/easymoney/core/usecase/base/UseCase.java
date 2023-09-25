package br.com.easymoney.core.usecase.base;

public interface UseCase <R,C> {

	R process(C command);
}
