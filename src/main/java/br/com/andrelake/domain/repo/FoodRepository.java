package br.com.andrelake.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrelake.domain.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
