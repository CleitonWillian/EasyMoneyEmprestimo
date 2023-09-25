package br.com.easymoney.core.command;

import java.math.BigDecimal;

public record LoanSaveCommand(String personId, int installmentQuantity, BigDecimal installmentValue) {

}
