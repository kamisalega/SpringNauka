package kamilsalega.springframework.services;

import kamilsalega.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
