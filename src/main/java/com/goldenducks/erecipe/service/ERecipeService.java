package com.goldenducks.erecipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.goldenducks.erecipe.entity.ERecipe;

@Service
public interface ERecipeService {
	
	public List<ERecipe> getAllERecipes();
	
	public ERecipe getERecipe(String username, String recipeName);
	
	public void createERecipe(ERecipe eRecipe);
	
	public List<ERecipe> searchERecipesByRecipeName(String username, String recipeName);
	
	public List<ERecipe> searchERecipesByRecipeType(String username, String recipeType);

	public void updateERecipe(ERecipe eRecipe);
	
	public void deleteERecipe(String username, String recipeName);

}
