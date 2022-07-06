package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Poroda;

import java.util.List;

public interface PorodaRepository extends CrudRepository<Poroda,Long> {
    Iterable<Poroda> findAllByVidAnimalId(Long id);
    Poroda findFirstById(Long id);
}
