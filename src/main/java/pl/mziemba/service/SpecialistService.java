package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Specialization;
import pl.mziemba.repository.SpecialistRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecialistService {

    public final SpecialistRepository specialistRepository;

    public void save(Specialist specialist) {
        specialistRepository.save(specialist);
    }

    public void update(Specialist specialist){
        specialistRepository.save(specialist);
    }

    public void deleteById(Long id){
        specialistRepository.deleteById(id);
    }

    public List<Specialist> findAll() {
        return specialistRepository.findAll();
    }

    public Specialist findById(Long id) {
        return specialistRepository.findById(id).get();
    }

    public List<Specialist> findByFirstNameAndLastName(String firstName, String lastName) {
        return specialistRepository.findByFirstNameContainsAndLastNameContains(firstName, lastName);
    }

    public List<Specialist> findByDateOfBirth(String dateOfBirth) {
        return specialistRepository.findByDateOfBirth(dateOfBirth);
    }
    public List<Specialist> findByPesel(String pesel) {
        return specialistRepository.findByPesel(pesel);
    }

    public  List<Specialist> findBySpecialization(Specialization specialization) {
        return specialistRepository.findBySpecialization(specialization);
    }
    public  List<Specialist> findBySpecializationByName(String name) {
        return specialistRepository.findBySpecializationName(name);
    }

}
