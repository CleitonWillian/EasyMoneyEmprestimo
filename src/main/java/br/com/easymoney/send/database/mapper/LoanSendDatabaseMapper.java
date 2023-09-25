package br.com.easymoney.send.database.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.easymoney.core.command.LoanSaveCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.core.dto.LoanInstallmentDTO;
import br.com.easymoney.send.database.entity.Loan;

@Component
public class LoanSendDatabaseMapper {

	public Loan from(LoanSaveCommand command) {
		Loan loanModel = Loan.builder()
			.personId(command.personId())
			.amount(command.installmentValue().multiply(new BigDecimal(command.installmentQuantity())))
			.installmentAmount(command.installmentValue())
			.installmentQuantity(command.installmentQuantity())
		.build();
		return loanModel;
	}

	public LoanDTO from(Loan savedLoanModel) {
		
		var loanInstallmentDTO = new LoanInstallmentDTO(savedLoanModel.getInstallmentQuantity(), savedLoanModel.getInstallmentAmount());
		
		var loan = new LoanDTO(savedLoanModel.getId(), savedLoanModel.getPersonId(), loanInstallmentDTO, savedLoanModel.getAmount());
		
		return loan;
	}

}
