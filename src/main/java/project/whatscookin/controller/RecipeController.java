package project.whatscookin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.whatscookin.models.data.forms.Recipe;
import project.whatscookin.models.data.forms.RecipeDao;

import javax.validation.Valid;

@Controller
@RequestMapping("recipe")
public class RecipeController {


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
    @RequestMapping(value = "food", method = RequestMethod.GET)
    public String viewSingleRecipe(Model model) {
        model.addAttribute("recipes", recipeDao.findOne(1));
        return "Recipes/food";
    }
}

