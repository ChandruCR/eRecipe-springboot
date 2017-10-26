package com.goldenducks.erecipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldenducks.erecipe.controller.ERecipeController;
import com.goldenducks.erecipe.dao.ERecipeRepository;
import com.goldenducks.erecipe.entity.ERecipe;
import com.goldenducks.erecipe.exception.ERecipeException;

@Component
public class ERecipeServiceImpl implements ERecipeService {

	@Autowired
	private ERecipeRepository eRecipeRepository;
	private static final Logger logger = LoggerFactory.getLogger(ERecipeController.class);

	// this method gets all recipes from mongo repository
	public List<ERecipe> getAllERecipes() {
		try {
			logger.debug("getAllERecipes method of ERecipeServiceImpl called");
			return eRecipeRepository.findAll();
		} catch (Exception e) {
			logger.debug("Exception in getAllERecipes method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}

	// this method gets complete details of a recipe from mongo repository
	public ERecipe getERecipe(String username, String recipeName) {
		try {
			logger.debug("getAllERecipes method of ERecipeServiceImpl called");
			return eRecipeRepository.findByUsernameAndRecipeName(username, recipeName);
		} catch (Exception e) {
			logger.debug("Exception in getAllERecipes method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() + "\r\n" + e.getCause() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}
	
	// this method creates new recipe in mongo repository
	public void createERecipe(ERecipe eRecipe) {
		try {
			logger.debug("createERecipe method of ERecipeServiceImpl called");
			eRecipeRepository.save(eRecipe);
		} catch (Exception e) {
			logger.debug("Exception in createERecipe method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() + "\r\n" + e.getCause() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}

	// this method gets all recipes from mongo repository matching username and recipeName passed to it
	public List<ERecipe> searchERecipesByRecipeName(String username, String recipeName) {
		try {
			logger.debug("searchERecipesByRecipeName method of ERecipeServiceImpl called");
			return eRecipeRepository.findByUsernameAndRecipeNameLike(username, recipeName);
		} catch (Exception e) {
			logger.debug("Exception in searchERecipesByRecipeName method of ERecipeServiceImpl \r\n  Exception Details:"+ e.getMessage() + "\r\n" + e.getCause() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}

	// this method gets all recipes from mongo repository matching username and recipeType passed to it
	public List<ERecipe> searchERecipesByRecipeType(String username, String recipeType) {
		try {
			logger.debug("searchERecipesByRecipeType method of ERecipeServiceImpl called");
			return eRecipeRepository.findByUsernameAndRecipeTypeLike(username, recipeType);
		} catch (Exception e) {
			logger.debug("Exception in searchERecipesByRecipeType method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() + "\r\n" + e.getCause() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}
	
	// this method updates a recipe in mongo repository
	public void updateERecipe(ERecipe eRecipe) {
		try {
			logger.debug("updateERecipe method of ERecipeServiceImpl called");
			eRecipeRepository.save(eRecipe);
		} catch (Exception e) {
			logger.debug("Exception in updateERecipe method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() + "\r\n" + e.getCause());
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}

	// this method deletes a reciped from mongo repository
	public void deleteERecipe(String username, String recipeName) {
		try {
			logger.debug("deleteERecipe method of ERecipeServiceImpl called");
			//eRecipeRepository.deleteByUsernameAndRecipeName(username, recipeName);
			eRecipeRepository.delete(eRecipeRepository.findByUsernameAndRecipeName(username, recipeName));
			//eRecipeRepository.deleteB
		} catch (Exception e) {
			logger.debug("Exception in deleteERecipe method of ERecipeServiceImpl \r\n Exception Details:"+ e.getMessage() + "\r\n" + e.getCause() );
			throw new ERecipeException(e.getCause() + e.getMessage());
		}
	}

}
