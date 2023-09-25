package br.com.easymoney.core.usecase;

import br.com.easymoney.core.command.PersonValidationCommand;
import br.com.easymoney.core.dto.ValidationDTO;
import br.com.easymoney.core.usecase.base.UseCase;

public interface PersonValidationUseCase extends UseCase<ValidationDTO, PersonValidationCommand>{

}
