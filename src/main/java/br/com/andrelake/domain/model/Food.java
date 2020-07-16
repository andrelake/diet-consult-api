package br.com.andrelake.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diet_consult")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "nome")
	private String nome;
	
	@PositiveOrZero
	@Column(name = "calorias")
	private Integer calorias;
	
	@PositiveOrZero
	@Column(name = "proteina")
	private Double proteina;
	
	@PositiveOrZero
	@Column(name = "gordura")
	private Double gordura;
	
	@PositiveOrZero
	@Column(name = "carbo")
	private Double carbo;
	
	@PositiveOrZero
	@Column(name = "fibra")
	private Double fibra;

}
