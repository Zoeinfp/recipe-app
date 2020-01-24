package de.phschaefer.recipeapp.service;

import de.phschaefer.recipeapp.domain.Recipe;
import de.phschaefer.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeHashSet = new HashSet<>();
        recipeHashSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeHashSet);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);

        verify(recipeRepository, times(1)).findAll();
    }
}