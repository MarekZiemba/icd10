package pl.mziemba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
