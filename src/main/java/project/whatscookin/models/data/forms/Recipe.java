package project.whatscookin.models.data.forms;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "No ingredients? Hmm, come back when you have some.")
    private String ingredients;

    @NotNull
    @Size(min=1, message = "DIY is cool and all, but a little guidance would be nice")
    private String directions;

    public Recipe() {

    }

    public Recipe(String name, String recipeText) {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
