package br.com.easymoney.receive.rest.controller.doc;

import org.springframework.http.ResponseEntity;

import br.com.easymoney.receive.rest.error.ErrorResponse;
import br.com.easymoney.receive.rest.request.LoanMakeRequestJson;
import br.com.easymoney.receive.rest.response.LoanResponseJson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Loan API", description = "API para fazer um emprestimo e atualizar o pagamento de um emprestimo")
public interface LoanControllerDoc {

	@Operation(summary = "Cria um emprestimo a partir do ID de uma pessoa", responses = {
			@ApiResponse(responseCode = "200", description = "Emprestimo efetuado com sucesso", content = @Content(schema = @Schema(implementation = LoanResponseJson.class))),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<LoanResponseJson> make(@Parameter(description = "ID da pessoa", required = true) String personId, 
			@Parameter(description = "Objeto para criar um emprestimo", required = true) LoanMakeRequestJson requestJson);

	@Operation(summary = "Atualiza o estado de emprestimo para pago", responses = {
			@ApiResponse(responseCode = "204", description = "Emprestimo atualizado para pago com sucesso"),
			@ApiResponse(responseCode = "400", description = "Argumento invalido",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Emprestimo não encontrado",content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
	ResponseEntity<Void> paymentConfirm(@Parameter(description = "ID do emprestimo", required = true)String id);

}
