package br.com.andrelake.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelake.domain.model.Food;
import br.com.andrelake.domain.service.FoodService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/foods")
public class FoodController {

	@Autowired
	private FoodService service;
	
	@GetMapping
	public ResponseEntity<List<Food>> getFoodList() {
		
		List<Food> foods = service.getAllFoods();
		
		return ResponseEntity.ok(foods);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
		
		Food food = service.getFoodById(id);
		
		return ResponseEntity.ok(food);
	}
}
