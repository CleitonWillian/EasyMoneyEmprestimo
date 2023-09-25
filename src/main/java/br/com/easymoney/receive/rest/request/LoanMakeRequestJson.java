package br.com.easymoney.receive.rest.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "FazerEmprestimo")
public class LoanMakeRequestJson {

	@JsonProperty("quantidadeDeParcelas")
	@NotNull
	@Schema(
		    type = "integer", 
		    description = "A quantidade de parcelas só pode ser numeros inteiros e não pode ser vazio ou nula", 
		    example = "2"
		    
		)
	private Integer installmentCount;

	@JsonProperty("valorDasParcelas")
	@NotNull
	@Schema(
		    type = "float", 
		    description = "O valor das parcelas representa o valor de cada parcela do emprestimo, "
		    		+ "este campo só pode ser numeros(farcionados) e não pode ser vazio ou nula", 
		    example = "200.00"
		    
		)
	private BigDecimal installmentValue;

}
