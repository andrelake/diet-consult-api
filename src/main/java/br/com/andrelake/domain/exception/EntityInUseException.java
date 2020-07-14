package br.com.andrelake.domain.exception;

public class EntityInUseException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public EntityInUseException(String msg) {
		super(msg);
	}
}
