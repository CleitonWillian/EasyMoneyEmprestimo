package br.com.easymoney.receive.rest.mapper;

import org.springframework.stereotype.Component;

import br.com.easymoney.core.command.LoanMakeCommand;
import br.com.easymoney.core.dto.LoanDTO;
import br.com.easymoney.receive.rest.request.LoanMakeRequestJson;
import br.com.easymoney.receive.rest.response.LoanInstallmentResponseJson;
import br.com.easymoney.receive.rest.response.LoanResponseJson;

@Component
public class LoanReceiveRestMapper {

	public LoanMakeCommand from(String personId, LoanMakeRequestJson requestJson) {
		
		return new LoanMakeCommand(personId, requestJson.getInstallmentCount(), requestJson.getInstallmentValue());
	}

	public LoanResponseJson from(LoanDTO loan) {

	    return LoanResponseJson.builder()
	            .id(loan.id())
	            .personId(loan.personId())
	            .totalValue(loan.value())
	            .installment(LoanInstallmentResponseJson.builder()
	    	            .quantity(loan.installment().quantity())
	    	            .value(loan.installment().value())
	    	            .build())
	            .build();
	}

}
