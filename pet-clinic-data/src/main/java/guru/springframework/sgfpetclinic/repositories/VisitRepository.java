package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
