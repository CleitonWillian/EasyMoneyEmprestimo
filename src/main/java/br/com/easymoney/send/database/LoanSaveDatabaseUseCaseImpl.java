package br.com.easymoney.send.database;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.command.LoanSaveCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.core.usecase.LoanSaveUseCase;
import br.com.easymoney.send.database.entity.Loan;
import br.com.easymoney.send.database.mapper.LoanSendDatabaseMapper;
import br.com.easymoney.send.database.repository.LoanRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanSaveDatabaseUseCaseImpl implements LoanSaveUseCase {

	private final LoanRepository repository;
	
	private final LoanSendDatabaseMapper mapper;
	
	@Override
	public LoanDTO process(LoanSaveCommand command) {
		
		Loan loanModel = mapper.from(command);
		
		Loan savedLoanModel = repository.save(loanModel);
		
		LoanDTO loan = mapper.from(savedLoanModel);
		
		return loan;
	}



}
