package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.Chart;
import ru.spring.P50218.kazanin.models.Tovar;

public interface ChartRepository extends CrudRepository<Chart,Long> {
    Iterable<Chart> findAllByUserId(Long id);
    Chart findFirstById(Long id);
}
