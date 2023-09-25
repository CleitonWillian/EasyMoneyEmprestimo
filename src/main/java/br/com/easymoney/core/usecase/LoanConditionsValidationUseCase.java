package br.com.easymoney.core.usecase;

import br.com.easymoney.core.command.LoanConditionsValidationCommand;
import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.usecase.base.UseCase;

public interface LoanConditionsValidationUseCase extends UseCase<ValidationDTO, LoanConditionsValidationCommand>{

}
