package pl.mziemba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Diagnosis;

import java.util.List;
import java.util.Optional;

public interface DiagnosisRepository  extends JpaRepository<Diagnosis, Long> {

    @Override
    List<Diagnosis> findAll();

    @Override
    Optional<Diagnosis> findById(Long id);

    List<Diagnosis> findByName(String name);

}
