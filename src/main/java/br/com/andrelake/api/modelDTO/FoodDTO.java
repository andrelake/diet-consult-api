package br.com.andrelake.api.modelDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

	private Long id;
	private String nome;
	private Integer calorias;
	private Double proteina;
	private Double gordura;
	private Double carbo;
	private Double fibra;
}
