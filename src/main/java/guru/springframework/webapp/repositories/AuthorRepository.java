package guru.springframework.webapp.repositories;

import guru.springframework.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
