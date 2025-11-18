package com.huangming.wecook.controller;

import com.huangming.wecook.dataclass.Recipe;
import com.huangming.wecook.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping
    public List<Recipe> getAllRecipes(@RequestParam(required = false) String query,
                                      @RequestParam(required = false, defaultValue = "NONE") String sort) {
        List<Recipe> list;
        if (query != null && !query.isEmpty()) {
            list = recipeRepo.searchByQuery(query);
        } else {
            list = recipeRepo.findAll();
        }

        switch (sort) {
            case "TITLE":
                list.sort(Comparator.comparing(Recipe::getTitle));
                break;
            case "DATE":
                list.sort(Comparator.comparing(Recipe::getDate));
                break;
            default:
                break;
        }
        return list;
    }

    @PostMapping
    public Integer insertRecipe(@RequestBody Recipe recipe) {
        Recipe saved = recipeRepo.save(recipe);
        return saved.getId();
    }

    @PutMapping
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeRepo.save(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeRepo.deleteById(id);
    }
}
