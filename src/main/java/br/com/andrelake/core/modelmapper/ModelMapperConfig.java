package br.com.andrelake.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.andrelake.api.modelDTO.FoodDTO;
import br.com.andrelake.domain.model.Food;


@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		var foodToModelTypeMap = modelMapper.createTypeMap(Food.class, FoodDTO.class);
		
		foodToModelTypeMap.<String>addMapping(foodSource -> foodSource.getNome(), 
				(foodDTODestiny, value) -> foodDTODestiny.setNome(value));
		
		return modelMapper;
	}
}
