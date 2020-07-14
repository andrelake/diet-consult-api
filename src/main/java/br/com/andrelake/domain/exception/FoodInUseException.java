package br.com.andrelake.domain.exception;

public class FoodInUseException extends EntityInUseException {

	private static final long serialVersionUID = 1L;

	public FoodInUseException(String msg) {

		super(msg);
	}

	public FoodInUseException(Long id) {

		this(String.format("Alimento com o id %d não pode ser excluído pois está em uso", id));
	}
}
