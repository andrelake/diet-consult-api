package br.com.andrelake.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.andrelake.api.modelDTO.FoodDTO;
import br.com.andrelake.domain.model.Food;

@Component
public class FoodDTOAssembler {

	@Autowired
	private ModelMapper mapper;
	
	public FoodDTO toModel(Food food) {
		
		return mapper.map(food, FoodDTO.class);
	}
	
	public List<FoodDTO> toColletionModel(List<Food> foods) {
		
		return foods.stream()
				.map(food -> toModel(food))
				.collect(Collectors.toList());
	}
}
