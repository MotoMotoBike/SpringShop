package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Poroda;
import ru.spring.P50218.kazanin.models.SovetPoUhody;

public interface SovetPoUhodyRepository extends CrudRepository<SovetPoUhody,Long> {
    Iterable<SovetPoUhody> findAllByPorodaId(Long id);
    SovetPoUhody findFirstById(Long id);
}
