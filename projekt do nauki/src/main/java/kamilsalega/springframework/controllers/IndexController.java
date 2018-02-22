package kamilsalega.springframework.controllers;

import kamilsalega.springframework.domain.Category;
import kamilsalega.springframework.domain.UnitOfMeasure;
import kamilsalega.springframework.repositories.CategoryRepository;
import kamilsalega.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){


        Optional<Category> category = categoryRepository.findByDescription("Amerykanska");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Lyzeczka");

        System.out.println("Id of Category: " + category.get().getId());
        System.out.println("Id of Unit of Measure: " + unitOfMeasure.get().getId());

        return "index";
    }
}
