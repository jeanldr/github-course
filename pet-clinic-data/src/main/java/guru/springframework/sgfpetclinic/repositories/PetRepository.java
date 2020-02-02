package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
