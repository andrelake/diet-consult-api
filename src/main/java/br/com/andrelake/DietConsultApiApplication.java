package br.com.andrelake;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.andrelake.domain.model.Food;
import br.com.andrelake.domain.service.FoodService;
import br.com.andrelake.util.FileLoader;

@SpringBootApplication
public class DietConsultApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DietConsultApiApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner runner(FoodService foodService) {
		
		return args -> {
			
			FileLoader fileLoader = new FileLoader();
			
			List<Food> foods = fileLoader.excelLoader();
			
			try {
				
				foodService.save(foods);
				
			}catch(Exception e) {
				System.out.println("Erro ao salvar no bd: " + e.getMessage());
			}
			
		};
	}
}
