package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Treatment;
import pl.mziemba.entity.Specialization;

import java.util.List;
import java.util.Optional;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    @Override
    @EntityGraph(attributePaths = "specialist")
    List<Treatment> findAll();

    @Override
    @EntityGraph(attributePaths = "specialist")
    Optional<Treatment> findById(Long id);

    @EntityGraph(attributePaths = "specialist")
    List<Treatment> findByName(String name);

    @EntityGraph(attributePaths = "specialist")
    List<Treatment> findBySpecialist(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = "service")
    List<Treatment> findBySpecialistFirstNameContainsAndLastNameContains(String firstName, String lastName);
    
}
