package br.com.easymoney.send.database.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import br.com.easymoney.send.database.entity.preset.EntityPreset;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity(name = "Emprestimos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@SQLDelete(sql = "UPDATE Emprestimos SET deletado = true WHERE id = ?")
@Where(clause = "deletado = false")
public class Loan extends EntityPreset {

	@Column(name = "quantidadeParcelas")
	private int installmentQuantity;
	
	@Column(name = "valorDasParcelas")
	private BigDecimal installmentAmount;

	@Column(name = "valor")
	private BigDecimal amount;

	@Column(name = "pessoaId")
	private String personId;

	@Column(name = "pago")
	private boolean paid;

}
