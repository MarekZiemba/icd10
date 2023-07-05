package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.*;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findAll();

    @Override
    @EntityGraph(attributePaths = {"specialist", "roles"})
    Optional<User> findById(Long id);

    @EntityGraph(attributePaths = {"specialist", "roles"})
    Optional<User> findByUsername(String username);
    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findByUsernameContains(String username);

    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findBySpecialist(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findBySpecialistFirstNameAndSpecialistLastName(String firstName, String lastName);

    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findByRoles(@Param("roles") Role roles);

    @EntityGraph(attributePaths = {"specialist", "roles"})
    List<User> findByRolesName(String name);

    User findById(Class<User> userClass, Long id);

}
