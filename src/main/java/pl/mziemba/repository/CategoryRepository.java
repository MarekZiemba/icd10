package pl.mziemba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mziemba.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long id);

    List<Category> findByName(String name);

}
