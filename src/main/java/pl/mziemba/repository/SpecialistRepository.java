package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Specialization;

import java.util.List;
import java.util.Optional;

public interface SpecialistRepository extends JpaRepository<Specialist, Long> {

    @Override
    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findAll();

    @Override
    @EntityGraph(attributePaths = "specializations")
    Optional<Specialist> findById(Long id);

    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findByPesel(String pesel);

    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findBySpecialization(@Param("specialization") Specialization specialization);

    @EntityGraph(attributePaths = "specializations")
    List<Specialist> findBySpecializationName(String name);

}
