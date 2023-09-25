package br.com.easymoney.receive.rest.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(name = "Parcela")
public class LoanInstallmentResponseJson {

	@Schema(
		    type = "integer", 
		    description = "Quantidade de parcelas do emprestimo", 
		    example = "3"
		)
	@JsonProperty("quantidade")
	private int quantity;
	
	@Schema(
		    type = "float", 
		    description = "Valor mensal das parcelas do empréstimo.", 
		    example = "300.00"
		)
	@JsonProperty("valor")
    private BigDecimal value;
}
