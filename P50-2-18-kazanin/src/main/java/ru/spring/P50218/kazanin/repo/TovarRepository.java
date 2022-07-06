package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Tovar;

public interface TovarRepository extends CrudRepository<Tovar,Long> {
    Iterable<Tovar> findAllByVidAnimalId(Long id);
    Tovar findFirstById(Long id);
}
