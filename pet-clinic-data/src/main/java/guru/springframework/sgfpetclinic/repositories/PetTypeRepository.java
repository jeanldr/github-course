package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
