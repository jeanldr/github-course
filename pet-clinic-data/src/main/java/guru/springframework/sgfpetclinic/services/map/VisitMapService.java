package guru.springframework.sgfpetclinic.services.map;

import guru.springframework.sgfpetclinic.model.Visit;
import guru.springframework.sgfpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (Objects.isNull(visit.getPet()) || Objects.isNull(visit.getPet().getOwner()) || Objects.isNull(visit.getPet().getId())
                || Objects.isNull(visit.getPet().getOwner().getId())) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
