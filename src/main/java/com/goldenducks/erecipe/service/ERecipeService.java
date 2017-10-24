package com.goldenducks.erecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenducks.erecipe.dao.ERecipeDao;
import com.goldenducks.erecipe.entity.ERecipe;

@Service
public class ERecipeService {

	@Autowired
	private ERecipeDao eRecipeDao;
	
	public List<ERecipe> getAllERecipes(String username){
		return eRecipeDao.getAllERecipes(username);
	}
	
	public String createERecipe(ERecipe eRecipe) {
		return eRecipeDao.createERecipe(eRecipe);
	}
	
	public List<ERecipe> searchERecipesByRecipeName(String username, String recipeName){
		return eRecipeDao.searchERecipesByRecipeName(username, recipeName);
	}
	
	public List<ERecipe> searchERecipesByRecipeType(String username, String recipeType){
		return eRecipeDao.searchERecipesByRecipeType(username, recipeType);
	}

	public String updateERecipe(ERecipe eRecipe) {
		eRecipeDao.updateERecipe(eRecipe);
		return null;
	}
	
	public String deleteERecipe(ERecipe eRecipe) {
		eRecipeDao.deleteERecipe(eRecipe);
		return null;
	}
	
	public ERecipe getERecipe(String username, String recipeName){
		return eRecipeDao.getERecipe(username, recipeName);
	}
}
