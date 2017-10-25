package com.goldenducks.erecipe.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.goldenducks.erecipe.entity.ERecipe;

@Repository
public interface ERecipeRepository extends MongoRepository<ERecipe, String> {
		
	 @Query(fields="{ 'id':1, 'recipeName' : 1, 'recipeType' : 1, 'username' : 1}")
	 public List<ERecipe> findByUsernameAndRecipeNameLike(String username, String recipeName);
	 
	 @Query(fields="{ 'id':1, 'recipeName' : 1, 'recipeType' : 1, 'username' : 1}")
	 public List<ERecipe> findByUsernameAndRecipeTypeLike(String username, String recipeType);
	 
	 public ERecipe findByUsernameAndRecipeName(String username, String recipeName);
	 
	 @Query(value = "{}", fields="{ 'id':1, 'recipeName' : 1, 'recipeType' : 1, 'username' : 1}")
	 public List<ERecipe> findAll();
	 
	 @Query(value="{ 'username' : ?0, 'recipeName': ?1}", delete = true)
	 public ERecipe deleteByUsernameAndRecipeName(String username, String recipeName);
}
