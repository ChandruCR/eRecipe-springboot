package com.goldenducks.erecipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldenducks.erecipe.entity.ERecipe;
import com.goldenducks.erecipe.service.ERecipeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/erecipe")
public class ERecipeController {

	@Autowired
	private ERecipeService eRecipeService;
	
	@GetMapping(value ="/{username}")
	public List<ERecipe> getAllERecipes(@PathVariable("username")String username){
		return eRecipeService.getAllERecipes(username);
	}
	
	@PostMapping(consumes = "application/json")
	public String createERecipe(@RequestBody ERecipe eRecipe) {
		return eRecipeService.createERecipe(eRecipe);
		
	}
	
	@GetMapping(value ="/searchbyname/{username}/{recipeName}")
	public List<ERecipe> searchERecipesByRecipeName(@PathVariable("username") String username, @PathVariable("recipeName") String recipeName) {
		return eRecipeService.searchERecipesByRecipeName(username, recipeName);
	}
	
	@GetMapping(value ="/searchbytype/{username}/{recipeType}")
	public List<ERecipe> searchERecipesByRecipeType(@PathVariable("username") String username, @PathVariable("recipeType")String recipeType) {
		return eRecipeService.searchERecipesByRecipeType(username, recipeType);
	}

	@PutMapping(consumes = "application/json")
	public String updateERecipe(@RequestBody ERecipe eRecipe) {
		return eRecipeService.updateERecipe(eRecipe);
	}
	
	@DeleteMapping
	public String deleteERecipe(ERecipe eRecipe) {
		eRecipeService.deleteERecipe(eRecipe);
		return null;
	}
	
	@GetMapping(value="/{username}/{recipeName}")
	public ERecipe getERecipe(@PathVariable("username") String username, @PathVariable("recipeName") String recipeName) {
		return eRecipeService.getERecipe(username, recipeName);
	}
	
}
