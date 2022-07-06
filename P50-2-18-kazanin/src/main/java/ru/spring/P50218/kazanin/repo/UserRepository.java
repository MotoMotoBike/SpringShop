package ru.spring.P50218.kazanin.repo;

import org.springframework.data.repository.CrudRepository;
import ru.spring.P50218.kazanin.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
