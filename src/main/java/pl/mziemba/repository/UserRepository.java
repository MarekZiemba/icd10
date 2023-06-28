package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @EntityGraph(attributePaths = {"specialist", "role"})
    List<User> findAll();

    @Override
    @EntityGraph(attributePaths = {"specialist", "role"})
    Optional<User> findById(Long id);

    @EntityGraph(attributePaths = {"specialist", "role"})
    Optional<User> findByUsername(String username);

    @EntityGraph(attributePaths = {"specialist", "role"})
    List<User> findBySpecialist(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = {"specialist", "role"})
    List<User> findBySpecialistFirstNameAndSpecialistLastName(String firstName, String lastName);

    @EntityGraph(attributePaths = {"specialist", "role"})
    List<User> findByRole(@Param("role") Role role);

    @EntityGraph(attributePaths = {"specialist", "role"})
    List<User> findByRoleName(String name);

}
