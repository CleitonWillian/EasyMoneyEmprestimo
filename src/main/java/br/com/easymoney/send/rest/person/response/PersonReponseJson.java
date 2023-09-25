package br.com.easymoney.send.rest.person.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class PersonReponseJson {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("documentoIdentificador")
	private String docIdentifier;
	
	@JsonProperty("nascidoEm")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate bornIn; 
	
	@JsonProperty("criadoEm")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	
	@JsonProperty("tipo")
	private String type;
	
	
	@JsonProperty("emprestimoCondicoes")
	private LoanConditionsResponseJson loanConditions; 
}
