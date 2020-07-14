package br.com.andrelake.api.modelDTO.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTOInput {

	private String nome;
	private Integer calorias;
	private Double proteina;
	private Double gordura;
	private Double carbo;
	private Double fibra;
}
