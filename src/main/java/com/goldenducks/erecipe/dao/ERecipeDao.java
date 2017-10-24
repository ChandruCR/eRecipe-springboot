package com.goldenducks.erecipe.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goldenducks.erecipe.entity.ERecipe;

@Repository
public class ERecipeDao {

	@Autowired
	private ERecipeRepository eRecipeRepository;
	
	public List<ERecipe> getAllERecipes(String username){
		return eRecipeRepository.findAllRecipesByUsername(username);
	}
	
	public String createERecipe(ERecipe eRecipe) {
		eRecipeRepository.save(eRecipe);
		return "success";
	}
	
	public List<ERecipe> searchERecipesByRecipeName(String username, String recipeName){
		return eRecipeRepository.findByUsernameAndRecipeNameLike(username, recipeName);
	}
	
	public List<ERecipe> searchERecipesByRecipeType(String username, String recipeType){
		return eRecipeRepository.findByUsernameAndRecipeTypeLike(username, recipeType);
	}

	public String updateERecipe(ERecipe eRecipe) {
		eRecipeRepository.save(eRecipe);
		return "success";
	}
	
	public String deleteERecipe(ERecipe eRecipe) {
		eRecipeRepository.delete(eRecipe);
		return "success";
	}
	
	public ERecipe getERecipe(String username, String recipeName){
		return eRecipeRepository.findByUsernameAndRecipeName(username, recipeName);
	}
}
