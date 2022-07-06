package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.VidAnimal;
public interface VidAnimalRepository extends CrudRepository<VidAnimal,Long> {
    VidAnimal findFirstById(Long id);
}
