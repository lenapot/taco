package tacos.service;

import tacos.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> findAll();
}
