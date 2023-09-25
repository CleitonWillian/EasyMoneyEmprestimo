package br.com.easymoney.core.usecase;

import br.com.easymoney.core.command.LoanSaveCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.core.usecase.base.UseCase;

public interface LoanSaveUseCase extends UseCase<LoanDTO, LoanSaveCommand> {


}
