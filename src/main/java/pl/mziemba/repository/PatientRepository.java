package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Override
    @EntityGraph(attributePaths = {"categories", "specialists", "insurance"})
    List<Patient> findAll();

    List<Patient> findByDateOfBirth(String prefix);
    List<Patient> findByPeselStartsWith(String prefix);
}
