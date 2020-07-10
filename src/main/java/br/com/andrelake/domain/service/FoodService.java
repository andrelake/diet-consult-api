package br.com.andrelake.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrelake.domain.model.Food;
import br.com.andrelake.domain.repo.FoodRepository;
import br.com.andrelake.util.FileLoader;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repository;
	
	public void save(List<Food> foods) {
		
		try {
			
			foods = FileLoader.excelLoader();
			repository.saveAll(foods);
			
		}catch(Exception e) {
			throw new RuntimeException("Falha ao salvar informaçoes: " + e.getMessage());
		}

	}
	
	public List<Food> getAllFoods() {
		
		return repository.findAll();
	}
}
