package project.whatscookin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import project.whatscookin.models.data.forms.Recipe;
import project.whatscookin.models.data.forms.RecipeDao;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class   RecipeController {


    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("title", "What's cookin? :)");

        return "Recipes/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String processAddaRecipe(Model model) {
        model.addAttribute("title", "Add your recipe!");
        model.addAttribute(new Recipe());
        return "Recipes/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRecipe(Model model, @ModelAttribute @Valid Recipe newRecipe,
                                   Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Recipes");
            return "Recipes/add";

        }

        recipeDao.save(newRecipe);
        return "redirect:";
    }
    @RequestMapping(value="/food/{id}", method=RequestMethod.GET)
    public String viewRecipe(Model model, @PathVariable int id){
        model.addAttribute("recipe", recipeDao.findOne(id));
        model.addAttribute("title", "Good luck, have fun!");
        return "Recipes/food";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRecipeForm(Model model) {
        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("title", "Delete a recipe");
        return "Recipes/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveRecipeForm(@RequestParam int[] recipeIds) {

        for (int recipeId : recipeIds) {
            recipeDao.delete(recipeId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "search")
    public String processSearchRecipe(Model model) {
        model.addAttribute("title", "Recipe's Found!");
        return "Recipes/search";
    }
}

