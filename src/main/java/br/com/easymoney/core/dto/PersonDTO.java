package br.com.easymoney.core.dto;

public record PersonDTO(String id, String docIdentifier, PersonType type, LoanConditionsDTO loandConditions) {

}
