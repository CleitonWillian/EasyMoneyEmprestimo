package br.com.easymoney.receive.rest.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(name = "Emprestimo")
public class LoanResponseJson {

	@Schema(
		    type = "String", 
		    description = "Um hash padrão SHA-1 para identificar o Empréstimo no sistema."
		    		+ " Esse id será usado para fazer outras requisições para obter informações do recurso."
		    		+ " Será formado por caracteres numeros e traços, será unico e sempre retornará valor.", 
		    example = "ba2a2b24-4439-486c-8a55-395ffd329722"
		)
	@JsonProperty("id")
	private String id;
	
	@Schema(
			type = "String", 
		    description = "Um hash padrão SHA-1 para identificar a Pessoa no sistema."
		    		+ " Esse id será usado para fazer outras requisições para obter informações do recurso."
		    		+ " Será formado por caracteres numeros e traços, será unico e sempre retornará valor.", 
		    example = "ba2a2b24-4439-486c-8a55-395ffd329722"
		)
	@JsonProperty("idDaPessoa")
	private String personId;
	
	@JsonProperty("parcela")
	private LoanInstallmentResponseJson installment;
	
	@Schema(
		    type = "float", 
		    description = "Valor total do Empréstimo.", 
		    example = "300.00"
		)
	@JsonProperty("valor")
	private BigDecimal totalValue;

}
