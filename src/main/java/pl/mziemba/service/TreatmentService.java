package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.Treatment;
import pl.mziemba.repository.TreatmentRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TreatmentService {

    public final TreatmentRepository treatmentRepository;

    public void save(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    public void update(Treatment treatment){
        treatmentRepository.save(treatment);
    }

    public void deleteById(Long id){
        treatmentRepository.deleteById(id);
    }

    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    public Treatment findById(Long id) {
        return treatmentRepository.findById(id).get();
    }

    public List<Treatment> findByName(String name) {
        return treatmentRepository.findByName(name);
    }

//    public  List<Treatment> findBySpecialist(Specialist specialist) {
//        return treatmentRepository.findBySpecialist(specialist);
//    }
    public  List<Treatment> findBySpecialistFullName(String firstName, String lastName) {
        return treatmentRepository.findBySpecialistsFirstNameAndSpecialistsLastName(firstName, lastName);
    }
    
}
