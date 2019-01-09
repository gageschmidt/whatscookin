package project.whatscookin.models.data.forms;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional

public interface RecipeDao extends CrudRepository<Recipe, Integer> {
}
