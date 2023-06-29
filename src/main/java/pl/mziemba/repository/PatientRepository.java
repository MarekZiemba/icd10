package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Specialist;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findAll();

    @Override
    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    Optional<Patient> findById(Long id);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByPesel(String pesel);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByInsurance(String insurance);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByCategoriesContains(Category category);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByCategoriesNameContains(String name);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByDiagnosisContains(Diagnosis diagnosis);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findByDiagnosisNameContains(String name);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findBySpecialistsContains(Specialist specialist);

    @EntityGraph(attributePaths = {"categories", "diagnosis", "specialists"})
    List<Patient> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);

}