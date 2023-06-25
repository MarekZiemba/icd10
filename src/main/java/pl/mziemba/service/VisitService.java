package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.*;
import pl.mziemba.repository.VisitRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    public final VisitRepository visitRepository;

    public void save(Visit visit) {
        visitRepository.save(visit);
    }

    public void update(Visit visit){
        visitRepository.save(visit);
    }

    public void deleteById(Long id){
        visitRepository.deleteById(id);
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public Visit findById(Long id) {
        return visitRepository.findById(id).get();
    }

    public  List<Visit> findByPatient(Patient patient) {
        return visitRepository.findByPatient(patient);
    }
    public  List<Visit> findByPatientByFullName(String firstName, String lastName) {
        return visitRepository.findByPatientsFirstNameAndSpecialistsLastName(firstName, lastName);
    }

    public  List<Visit> findByTreatment(Treatment treatment) {
        return visitRepository.findByTreatment(treatment);
    }
    public  List<Visit> findByTreatmentByName(String name) {
        return visitRepository.findByTreatmentName(name);
    }

    public  List<Visit> findBySpecialist(Specialist specialist) {
        return visitRepository.findBySpecialist(specialist);
    }
    public  List<Visit> findBySpecialistByFullName(String firstNAme, String lastName) {
        return visitRepository.findBySpecialistsFirstNameAndSpecialistsLastName(firstNAme, lastName);
    }

}
