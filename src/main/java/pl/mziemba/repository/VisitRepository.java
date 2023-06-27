package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.*;

import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Override
    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findAll();

    @Override
    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    Optional<Visit> findById(Long id);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByDateOfVisitOrderByTimeOfVisit(String dateOfVisit);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByDateOfVisitAndTimeOfVisit(String dateOfVisit, String timeOfVisit);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByPatient(@Param("patient") Patient patient);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByPatientFirstNameAndPatientLastName(String firstName, String lastName);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByTreatment(@Param("treatment") Treatment treatment);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findByTreatmentName(String name);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findBySpecialist(@Param("specialist") Specialist specialist);

    @EntityGraph(attributePaths = {"patient", "treatment", "specialist"})
    List<Visit> findBySpecialistFirstNameAndSpecialistLastName(String firstName, String lastName);

}
