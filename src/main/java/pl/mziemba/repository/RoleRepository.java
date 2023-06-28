package pl.mziemba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    List<Role> findAll();

    @Override
    Optional<Role> findById(Long id);

    List<Role> findByName(String name);

}
