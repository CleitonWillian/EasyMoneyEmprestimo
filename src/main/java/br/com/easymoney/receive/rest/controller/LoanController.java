package br.com.easymoney.receive.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easymoney.core.usecase.LoanMakeUseCase;
import br.com.easymoney.core.usecase.LoanUpadatePaymentConfirmUseCase;
import br.com.easymoney.receive.rest.controller.doc.LoanControllerDoc;
import br.com.easymoney.receive.rest.mapper.LoanReceiveRestMapper;
import br.com.easymoney.receive.rest.request.LoanMakeRequestJson;
import br.com.easymoney.receive.rest.response.LoanResponseJson;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/emprestimos")
@AllArgsConstructor
public class LoanController implements LoanControllerDoc{
	
	private final LoanMakeUseCase loanMake;
	
	private final LoanUpadatePaymentConfirmUseCase updatePaymentConfirm;
	
	private final LoanReceiveRestMapper mapper;
	
	@Override
	@PostMapping("/pessoa/{id}")
	public ResponseEntity<LoanResponseJson> make(@PathVariable(value = "id", required = true ) String personId,@Valid @RequestBody LoanMakeRequestJson requestJson){
	
		var command =  mapper.from(personId, requestJson);
		
		var loan = loanMake.process(command);
		
		var responseJson = mapper.from(loan);
		
		return ResponseEntity.ok(responseJson);
		
	}
	
	@Override
	@PostMapping("{id}/pagamento/confirmar")
	public ResponseEntity<Void> paymentConfirm(@PathVariable(required = true ) String id){
		
		updatePaymentConfirm.process(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
