package kamilsalega.springframework.controllers;

import kamilsalega.springframework.domain.Category;
import kamilsalega.springframework.domain.UnitOfMeasure;
import kamilsalega.springframework.repositories.CategoryRepository;
import kamilsalega.springframework.repositories.UnitOfMeasureRepository;
import kamilsalega.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

   private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){


        model.addAttribute("recipes", recipeService.getRecipes());






        return "index";
    }
}
