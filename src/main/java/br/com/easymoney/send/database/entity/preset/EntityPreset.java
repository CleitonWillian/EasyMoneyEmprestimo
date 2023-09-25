package br.com.easymoney.send.database.entity.preset;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class EntityPreset {

	@Id
	@Builder.Default
	private final String id = UUID.randomUUID().toString();
	
	@Builder.Default
	@Column(name = "criadoEm", nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Builder.Default
	@Column(name = "deletado", nullable = false)
	private boolean deleted = false;
	
	
	
	
}