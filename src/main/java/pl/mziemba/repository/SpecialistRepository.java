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
    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findAll();

    @Override
    @EntityGraph(attributePaths = "specialization")
    Optional<Specialist> findById(Long id);

    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findByPesel(String pesel);

    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findBySpecialization(@Param("specialization") Specialization specialization);

    @EntityGraph(attributePaths = "specialization")
    List<Specialist> findBySpecializationName(String name);

    Specialist findById(Class<Specialist> specialistClass, Long id);
}
