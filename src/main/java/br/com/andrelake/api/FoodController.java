//package br.com.andrelake.api;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import br.com.andrelake.domain.model.Food;
//import br.com.andrelake.domain.service.FoodService;
//import br.com.andrelake.util.ExcelHelper;
//
//@CrossOrigin("http://localhost:8080")
//@RestController
//@RequestMapping("/api/foods")
//public class FoodController {
//
//	@Autowired
//	private FoodService service;
//	
//	@PostMapping("/upload")
//	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
//		
//		if(ExcelHelper.hasExcelFormat(file)) {
//			
//			try {
//				
//				service.save(file);
//				return ResponseEntity.status(HttpStatus.CREATED).build();
//			}catch(Exception e) {
//				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
//			}
//		}
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//	}
//	
//	@GetMapping("/foods")
//	public ResponseEntity<List<Food>> getFoodList() {
//		
//		try {
//			
//			List<Food> foods = service.getAllFoods();
//			
//			if(foods.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			
//			return new ResponseEntity<>(foods, HttpStatus.OK);
//		}catch(Exception e) {
//			
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//}
