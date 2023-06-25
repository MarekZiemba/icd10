package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.*;

import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Override
    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findAll();

    @Override
    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    Optional<Visit> findById(Long id);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findByDateAAndTimeOfVisit(String dateOfVisit, String timeOfVisit);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findByPatient(@Param("patient") Patient patient);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findByPatientsFirstNameAndSpecialistsLastName(String firstName, String lastName);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findByTreatment(@Param("treatment") Treatment treatment);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findByTreatmentName(String name);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findBySpecialist(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = {"patients", "treatments", "specialists"})
    List<Visit> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);

}
