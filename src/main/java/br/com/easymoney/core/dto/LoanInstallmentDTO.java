package br.com.easymoney.core.dto;

import java.math.BigDecimal;

public record LoanInstallmentDTO(int quantity, BigDecimal value ) {

}
