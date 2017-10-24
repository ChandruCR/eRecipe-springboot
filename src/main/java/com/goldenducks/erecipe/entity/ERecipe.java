package com.goldenducks.erecipe.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.crossstore.RelatedDocument;


@Document(collection = "eRecipe")
@CompoundIndex (name = "user_recipe_ind", def = "{'username': 1, 'recipeName': 1}", unique = true)
public class ERecipe {

	@Id
	private String id;
	@Indexed
	private String recipeName;
	@Field("recipeType")
	private String recipeType;
	@Indexed
	private String username;
	@RelatedDocument
	private ERecipeDetails eRecipeDetails;
	
	public ERecipe() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}
	public ERecipeDetails geteRecipeDetails() {
		return eRecipeDetails;
	}

	public void seteRecipeDetails(ERecipeDetails eRecipeDetails) {
		this.eRecipeDetails = eRecipeDetails;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
