package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
