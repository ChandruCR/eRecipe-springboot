package com.goldenducks.erecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.goldenducks.erecipe.controller.ERecipeController;
import com.goldenducks.erecipe.entity.ERecipe;
import com.goldenducks.erecipe.entity.ERecipeDetails;
import com.goldenducks.erecipe.service.ERecipeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ERecipeController.class, secure = false)
public class ERecipeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private ERecipeService eRecipeService;
	
	List<ERecipe> mockERecipeList = new ArrayList<ERecipe>();
	
	ERecipe mockERecipe = new ERecipe();
	
	@BeforeClass
	public void setup() {
		ERecipeDetails eRecipeDetails = new ERecipeDetails();
		eRecipeDetails.addInfo("description", "this is description for this recipe");
		eRecipeDetails.addInfo("tags", "this is a tag for this recipe");
		ERecipe eRecipe = new ERecipe();
		eRecipe.setId("1001");
		eRecipe.setRecipeName("MockRecipeName");
		eRecipe.setRecipeType("MockRecipeType");
		eRecipe.setUsername("MockUsername");
		eRecipe.seteRecipeDetails(eRecipeDetails);
		this.mockERecipeList.add(eRecipe);
	}
	@Test
	public void testGetAllRecipe() throws Exception {	
		
		Mockito.when(
				eRecipeService.getAllERecipes()).thenReturn(this.mockERecipeList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/erecipe/MockUsername").accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "[{\"id\":\"1001\",\"recipeName\":\"MockRecipeName\",\"recipeType\":\"MockRecipeType\",\"username\":\"MockUsername\",\"eRecipeDetails\":{\"info\":{\"description\":\"this is description for this recipe\",\"tags\":\"this is a tag for this recipe\"}}}]";
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
		
	}
	
	

}
