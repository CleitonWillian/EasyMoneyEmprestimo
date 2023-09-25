package br.com.easymoney.core.dto;

import java.math.BigDecimal;

public record LoanDTO(String id, String personId, LoanInstallmentDTO installment, BigDecimal value) {

}
