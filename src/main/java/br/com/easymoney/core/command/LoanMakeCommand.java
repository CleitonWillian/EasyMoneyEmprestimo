package br.com.easymoney.core.command;

import java.math.BigDecimal;

public record LoanMakeCommand(String personId, int installmentQuantiy, BigDecimal installmentValue) {

}
