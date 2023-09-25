package br.com.easymoney.core.dto;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.function.Supplier;


public record ValidationDTO(List<String> messages) {

	public static ValidationDTO from(String message) {
		return new ValidationDTO(List.of(message));
	}
	
	public static ValidationDTO ok() {
		return new ValidationDTO(emptyList());
	}

	public boolean isSuccess() {
		return messages.isEmpty();
	}
	
	public boolean isUnsuccessful() {
		return !messages.isEmpty();
	}
	
	public <T extends Throwable> void ifUnsuccessfulThrow(Supplier<? extends T> exceptionSupplier) throws T {
        if (isUnsuccessful()) {
            throw sneakyThrow(exceptionSupplier.get());
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> T sneakyThrow(Throwable t) throws T {
        throw (T) t;
    }
}
