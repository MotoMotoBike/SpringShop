package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Image;

public interface ImageRepository extends CrudRepository<Image,Long> {
    Image findByUrl(String url);
}
