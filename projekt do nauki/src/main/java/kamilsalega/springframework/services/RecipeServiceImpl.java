package kamilsalega.springframework.services;

import kamilsalega.springframework.commands.RecipeCommand;
import kamilsalega.springframework.converters.RecipeCommandToRecipe;
import kamilsalega.springframework.converters.RecipeToRecipeCommand;
import kamilsalega.springframework.domain.Recipe;
import kamilsalega.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Recipe findById(Long id) {


        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Nie znaleziono przepisu!");
        }

        return recipeOptional.get();
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("Jestem w serwisie");

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);



        return recipeSet;
    }


    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {


        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);


        Recipe savedRecipe = recipeRepository.save(detachedRecipe);

        log.debug("Saved RecipeId:" + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {

        return recipeToRecipeCommand.convert(findById(id));


    }
}
