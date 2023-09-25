package br.com.easymoney.send.rest.person.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanConditionsResponseJson {

	@JsonProperty("valorMinimoParelas")
	private BigDecimal minInstallmentAmount;
	
	@JsonProperty("valorMaximoTotal")
    private  BigDecimal maxTotalAmount;
}
