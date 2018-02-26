package kamilsalega.springframework.controllers;

import kamilsalega.springframework.domain.Category;
import kamilsalega.springframework.domain.UnitOfMeasure;
import kamilsalega.springframework.repositories.CategoryRepository;
import kamilsalega.springframework.repositories.UnitOfMeasureRepository;
import kamilsalega.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;



@Slf4j
@Controller
public class IndexController {

   private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        log.debug("Getting Index Page");



        model.addAttribute("recipes", recipeService.getRecipes());






        return "index";
    }
}
