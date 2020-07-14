package br.com.andrelake.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.andrelake.api.modelDTO.input.FoodDTOInput;
import br.com.andrelake.domain.model.Food;

@Component
public class FoodDTODisassembler {

	@Autowired
	private ModelMapper mapper;
	
	public Food toDomainObject(FoodDTOInput foodDTOInput) {
		
		return mapper.map(foodDTOInput, Food.class);
	}
	
	public void copyToDomainObject(FoodDTOInput foodDTOInput, Food food) {
		
		mapper.map(foodDTOInput, food);
	}
}
