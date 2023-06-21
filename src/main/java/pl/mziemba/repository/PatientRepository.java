package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Insurance;
import pl.mziemba.entity.Category;
import pl.mziemba.entity.Specialist;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"insurance"})
//    @EntityGraph(attributePaths = {"categories", "specialists", "insurance"})
    List<Patient> findAll();

    @EntityGraph(attributePaths = {"insurance"})
//    @EntityGraph(attributePaths = {"insurance", "specialists", "categories"})
    List<Patient> findByFirstNameAndLastName(String firstName, String lastName);


    @EntityGraph(attributePaths = {"insurance"})
    List<Patient> findByDateOfBirth(String prefix);

    @EntityGraph(attributePaths = {"insurance"})
    List<Patient> findByPeselStartsWith(String prefix);


}
