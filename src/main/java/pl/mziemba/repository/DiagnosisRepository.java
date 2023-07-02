package pl.mziemba.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface DiagnosisRepository  extends JpaRepository<Diagnosis, Long> {

    @Override
//    @EntityGraph(attributePaths = "patients")
    List<Diagnosis> findAll();

    @Override
//    @EntityGraph(attributePaths = "patients")
    Optional<Diagnosis> findById(Long id);

//    @EntityGraph(attributePaths = "patients")
    List<Diagnosis> findByName(String name);

//    @EntityGraph(attributePaths = "patients")
//    Diagnosis findById(Class<Diagnosis> diagnosisClass, Long id);

//    @EntityGraph(attributePaths = "patients")
//    List<Diagnosis> findByPatientsContains(Patient patient);

}
