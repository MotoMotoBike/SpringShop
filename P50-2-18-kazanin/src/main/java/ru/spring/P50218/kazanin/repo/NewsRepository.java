package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.News;

public interface NewsRepository extends CrudRepository<News,Long> {
    Iterable<News> findAllById(Long id);
    News findFirstById(Long id);
    Iterable<News> findAllByKategoryId(Long id);

}
