package br.com.andrelake.domain.exception;

public class FoodNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public FoodNotFoundException(String msg) {

		super(msg);
	}

	public FoodNotFoundException(Long id) {

		this(String.format("Alimento com o id %d não foi encontrado", id));
	}
}
