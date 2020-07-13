package br.com.andrelake.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrelake.domain.exception.FoodNotFoundException;
import br.com.andrelake.domain.model.Food;
import br.com.andrelake.domain.repo.FoodRepository;
import br.com.andrelake.util.FileLoader;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repository;
	
	
	public List<Food> getAllFoods() {
		
		return repository.findAll();
	}
	
	public Food getFoodById(Long id) {
		
		Food food = findOrFail(id);
		
		return food;
	}
	
	public void saveFood(Food food) {
		
		if(food != null) {
			repository.save(food);
		} else {
			throw new NullPointerException("Entidade alimento está em estado 'null'");
		}
	}
	
	//util
	public Food findOrFail(Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new FoodNotFoundException(id));
	}
	
	//for file
	public void saveDataFromFile(List<Food> foods) {
		
		try {
			
			foods = FileLoader.excelLoader();
			repository.saveAll(foods);
			
		}catch(Exception e) {
			throw new RuntimeException("Falha ao salvar informaçoes: " + e.getMessage());
		}
	}
}
