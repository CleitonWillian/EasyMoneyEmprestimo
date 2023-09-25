package br.com.easymoney.core.dto;

import java.math.BigDecimal;

public record LoanConditionsDTO(BigDecimal minInstallmentAmount,BigDecimal maxTotalAmount) {

}
