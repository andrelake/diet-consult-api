package br.com.andrelake.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andrelake.api.assembler.FoodDTOAssembler;
import br.com.andrelake.api.assembler.FoodDTODisassembler;
import br.com.andrelake.api.modelDTO.FoodDTO;
import br.com.andrelake.api.modelDTO.input.FoodDTOInput;
import br.com.andrelake.domain.model.Food;
import br.com.andrelake.domain.service.FoodService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/foods")
public class FoodController {

	@Autowired
	private FoodService service;
	
	@Autowired
	private FoodDTOAssembler assembler;
	
	@Autowired
	private FoodDTODisassembler disassembler;
	
	@GetMapping
	public ResponseEntity<List<FoodDTO>> getFoodList() {
		
		List<Food> foods = service.getAllFoods();
		
		return ResponseEntity.ok(assembler.toColletionModel(foods));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FoodDTO> getFoodById(@PathVariable Long id) {
		
		Food food = service.getFoodById(id);
		
		return ResponseEntity.ok(assembler.toModel(food));
	}
	
	@PostMapping
	public ResponseEntity<FoodDTO> insertFood(@RequestBody @Valid FoodDTOInput foodDTOInput) {
		
		Food food = disassembler.toDomainObject(foodDTOInput);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toModel(service.saveFood(food)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FoodDTO> updateFood(@PathVariable Long id, @RequestBody @Valid FoodDTOInput foodDTOInput) {
		
		Food oldFood = service.getFoodById(id);
		
		disassembler.copyToDomainObject(foodDTOInput, oldFood);
		
		oldFood = service.saveFood(oldFood);
		
		return ResponseEntity.ok(assembler.toModel(oldFood));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
		
		service.deleteFoodById(id);
		
		return ResponseEntity.noContent().build();
	}
}
