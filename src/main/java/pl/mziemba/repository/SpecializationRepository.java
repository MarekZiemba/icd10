package pl.mziemba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Specialization;

import java.util.List;
import java.util.Optional;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    @Override
    List<Specialization> findAll();

    @Override
    Optional<Specialization> findById(Long id);

    List<Specialization> findByName(String name);

}
