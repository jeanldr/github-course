package guru.springframework.sgfpetclinic.services;

import guru.springframework.sgfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
