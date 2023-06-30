package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findAll();

    @Override
    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    Optional<Patient> findById(Long id);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByPesel(String pesel);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByInsurance(String insurance);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByDiagnosesContains(Diagnosis diagnosis);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findByDiagnosesNameContains(String name);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findBySpecialistsContains(Specialist specialist);

    @EntityGraph(attributePaths = {"diagnoses", "specialists"})
    List<Patient> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);

}