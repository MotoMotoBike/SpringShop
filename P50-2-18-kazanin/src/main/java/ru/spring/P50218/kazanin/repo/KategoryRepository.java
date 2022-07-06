package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Kategory;

public interface KategoryRepository extends CrudRepository<Kategory,Long> {
    Kategory findFirstById(Long id);
}
