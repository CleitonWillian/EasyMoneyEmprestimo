package br.com.easymoney.core.command;

import java.math.BigDecimal;

import br.com.easymoney.core.dto.LoanConditionsDTO;
import br.com.easymoney.core.dto.PersonType;

public record LoanConditionsValidationCommand(PersonType type, int installmentQuantity, BigDecimal installmentValue, LoanConditionsDTO loanConditions) {

}
