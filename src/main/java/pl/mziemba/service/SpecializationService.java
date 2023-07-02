package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Specialization;
import pl.mziemba.repository.SpecializationRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecializationService {
    
    private final SpecializationRepository specializationRepository;

    public void save(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public void update(Specialization specialization){
        specializationRepository.save(specialization);
    }

    public void deleteById(Long id){
        Specialization specialization = specializationRepository.findById(Specialization.class, id);
        specialization.removeAllSpecialists();
        specializationRepository.deleteById(id);
    }

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Specialization findById(Long id) {
        return specializationRepository.findById(id).get();
    }

    public List<Specialization> findByName(String name) {
        return specializationRepository.findByName(name);
    }
}
