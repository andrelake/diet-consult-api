package br.com.andrelake.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "calorias")
	private Integer calorias;
	
	@Column(name = "proteina")
	private Double proteina;
	
	@Column(name = "gordura")
	private Double gordura;
	
	@Column(name = "carbo")
	private Double carbo;
	
	@Column(name = "fibra")
	private Double fibra;

}
