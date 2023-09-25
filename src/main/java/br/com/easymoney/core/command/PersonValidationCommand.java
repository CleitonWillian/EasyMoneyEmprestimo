package br.com.easymoney.core.command;

import br.com.easymoney.core.dto.PersonType;

public record PersonValidationCommand(String id, String docIdentifier, PersonType type) {

}
