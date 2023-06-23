package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Category;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"categories", "specialists"})
    List<Patient> findAll();

    @Override
    @EntityGraph(attributePaths = {"categories", "specialists"})
    Optional<Patient> findById(Long id);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByFirstNameContainsAndLastNameContains(String firstName, String lastName);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByDateOfBirth(String dateOfBirth);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByPesel(String pesel);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByInsurance(String insurance);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByCategoriesContains(Category category);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findByCategoriesNameContains(String name);

    @EntityGraph(attributePaths = {"specialists", "categories"})
    List<Patient> findBySpecialistsFirstNameAndSpecialistsLastName(String firstName, String lastName);

}