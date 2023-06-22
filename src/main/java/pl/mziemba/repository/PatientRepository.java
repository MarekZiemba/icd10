package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Insurance;
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Specialist;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"categories", "specialists", "insurance"})
    List<Patient> findAll();

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByPesel(String pesel);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByInsurance(@Param("insurance") Insurance insurance);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByInsuranceInsuranceNumberContains(String insuranceNumber);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByCategoriesContains(Category category);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByCategoriesNameContains(String name);

    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);

}