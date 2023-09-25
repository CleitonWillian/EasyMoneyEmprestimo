package br.com.easymoney.core.bussineslogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.easymoney.core.command.LoanConditionsValidationCommand;
import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.usecase.LoanConditionsValidationUseCase;

@Service
public class LoanConditionsValidationsUseCaseImpl implements LoanConditionsValidationUseCase{

	@Override
	public ValidationDTO process(LoanConditionsValidationCommand command) {
		
		List<String> messages = new ArrayList<>();
		
		if (command.installmentQuantity() > 24) {
             messages.add("O número de parcelas não pode exceder 24.");
        }

        BigDecimal minInstallmentAmount = command.loanConditions().minInstallmentAmount();
        BigDecimal maxTotalAmount = command.loanConditions().maxTotalAmount();

        if (command.installmentValue().compareTo(minInstallmentAmount) < 0) {
        	messages.add("O valor das parcelas não pode ser inferior ao valor mínimo permitido.");
        }

        BigDecimal totalLoanAmount = command.installmentValue().multiply(new BigDecimal(command.installmentQuantity()));
        if (totalLoanAmount.compareTo(maxTotalAmount) > 0) {
        	messages.add("O empréstimo excede o limite máximo permitido.");
        }
        
        return new ValidationDTO(messages);
	}

}
