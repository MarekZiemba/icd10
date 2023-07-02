package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    @Override
    @EntityGraph(attributePaths = "specialists")
    List<Treatment> findAll();

    @Override
    @EntityGraph(attributePaths = "specialists")
    Optional<Treatment> findById(Long id);

    @EntityGraph(attributePaths = "specialists")
    List<Treatment> findByName(String name);

    @EntityGraph(attributePaths = "specialists")
    List<Treatment> findBySpecialists(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = "specialists")
    List<Treatment> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);
    
}

