package br.com.easymoney.core.bussineslogic;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.easymoney.core.command.LoanConditionsValidationCommand;
import br.com.easymoney.core.dto.LoanConditionsDTO;

class LoanConditionsValidationsUseCaseImplTest {
	
	LoanConditionsValidationsUseCaseImpl useCase = new LoanConditionsValidationsUseCaseImpl();

	@Test
	@DisplayName("Teste: Todos os Parâmetros do Empréstimo São Válidos")
	void testAllLoanParametersAreValid() {
	    var loanConditions = new LoanConditionsDTO(BigDecimal.TEN, new BigDecimal(200));
	    var command = new LoanConditionsValidationCommand(null, 10, BigDecimal.TEN, loanConditions);

	    var validation = useCase.process(command);

	    List<String> messages = validation.messages();
	    assertThat(messages).isEmpty();  
	    assertThat(validation.isSuccess()).isTrue();  
	}
	
    @Test
    @DisplayName("Teste: Número de Parcelas Excede Limite")
    void testInstallmentQuantityExceedsLimit() {
        var loanConditions = new LoanConditionsDTO(BigDecimal.TEN, BigDecimal.ONE);
        var command = new LoanConditionsValidationCommand(null,25, BigDecimal.TEN, loanConditions);
        
        var validation = useCase.process(command);
        
        List<String> messages = validation.messages();
        assertThat(messages).contains("O número de parcelas não pode exceder 24.");
        assertThat(validation.isUnsuccessful()).isTrue();
    }

    @Test
    @DisplayName("Teste: Valor das Parcelas Menor que o Permitido")
    void testInstallmentValueLessThanMin() {
        var loanConditions = new LoanConditionsDTO(BigDecimal.TEN, new BigDecimal(100));
        var command = new LoanConditionsValidationCommand(null,20, BigDecimal.ONE, loanConditions);
        
        var validation = useCase.process(command);
        
        List<String> messages = validation.messages();
        assertThat(messages).contains("O valor das parcelas não pode ser inferior ao valor mínimo permitido.");
        assertThat(validation.isUnsuccessful()).isTrue();
    }

    @Test
    @DisplayName("Teste: Valor Total do Empréstimo Excede o Limite")
    void testTotalLoanAmountExceedsLimit() {
        var loanConditions = new LoanConditionsDTO(BigDecimal.TEN, new BigDecimal(100));
        var command = new LoanConditionsValidationCommand(null,20, BigDecimal.TEN, loanConditions);


        var validation = useCase.process(command);

        List<String> messages = validation.messages();
        assertThat(messages).contains("O empréstimo excede o limite máximo permitido.");
        assertThat(validation.isUnsuccessful()).isTrue();
    }
}
