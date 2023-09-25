package br.com.easymoney.send.database;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.exception.client.LoanNotFoundException;
import br.com.easymoney.core.usecase.LoanUpadatePaymentConfirmUseCase;
import br.com.easymoney.send.database.repository.LoanRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoanUpdatePaymentConfirmeUseCaseImpl implements LoanUpadatePaymentConfirmUseCase {

	private LoanRepository repository;
	
	@Override
	public Void process(String command) {
		
		var loanEntity = repository.findById(command).orElseThrow(() -> new LoanNotFoundException());
		loanEntity.setPaid(true);
		repository.save(loanEntity);
		
		return null;
	}

}
