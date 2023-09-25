package br.com.easymoney.core.usecase;

import br.com.easymoney.core.command.LoanMakeCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.core.usecase.base.UseCase;

public interface LoanMakeUseCase extends UseCase<LoanDTO, LoanMakeCommand> {

}
