package br.com.easymoney.send.rest.payment.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service", url = "http://localhost:8070/pagamentos")
public interface PaymentConnector {

	@PostMapping("/emprestimo/{id}/confirmar")
	public ResponseEntity<Void> confirm(@PathVariable(value = "id", required = true)String loanId );
}
