package br.com.easymoney.send.rest.payment;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.usecase.PaymentMakeUseCase;
import br.com.easymoney.send.rest.payment.connector.PaymentConnector;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentMakeUseCaseImpl implements PaymentMakeUseCase {

	private PaymentConnector connector;
	
	@Override
	public Void process(String loanId) {
		
		connector.confirm(loanId);
		
		return null;
	}

}
