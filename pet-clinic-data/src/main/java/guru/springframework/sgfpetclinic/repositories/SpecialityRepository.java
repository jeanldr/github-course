package guru.springframework.sgfpetclinic.repositories;

import guru.springframework.sgfpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
