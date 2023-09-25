package br.com.easymoney.core.dto;

import static java.util.Arrays.stream;

import java.util.Optional;

import lombok.Getter;

@Getter
public enum PersonType {

	PF("PESSOA FISICA"), PJ("PESSOA JURIDICA"), EU("ESTUDANTE UNIVERSITARIO"), AP("APOSENTADO");

	private final String label;

	PersonType(String label) {
		this.label = label;

	}

	public static Optional<PersonType> findByLabel(String label) {
		return stream(values())
				.filter(type -> type.getLabel().equalsIgnoreCase(label))
				.findFirst();
	}

}
