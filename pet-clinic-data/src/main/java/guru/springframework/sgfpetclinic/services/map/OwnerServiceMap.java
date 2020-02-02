package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Owner;
import guru.springframework.sgfpetclinic.model.Pet;
import guru.springframework.sgfpetclinic.services.OwnerService;
import guru.springframework.sgfpetclinic.services.PetService;
import guru.springframework.sgfpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (Objects.isNull(object)) {
            return null;
        }

        if (Objects.nonNull(object.getPets())) {
            object.getPets().forEach(pet -> {
                if (Objects.nonNull(pet.getPetType())) {
                    if (Objects.isNull(pet.getPetType().getId())) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("PetType is required!");
                }

                if (Objects.isNull(pet.getId())) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }

            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
