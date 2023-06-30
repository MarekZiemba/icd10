package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.*;
import pl.mziemba.repository.PatientRepository;
import pl.mziemba.repository.VisitRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    public final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    public void save(Visit visit) {
        visitRepository.save(visit);
    }

    public void update(Visit visit){
        visitRepository.save(visit);
    }

    public void deleteById(Long id){
//        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
//        List<Visit> visits = visitRepository.findByPatient(patient);
//        visitRepository.deleteAll(visits);
        visitRepository.deleteById(id);
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public Visit findById(Long id) {
        return visitRepository.findById(id).get();
    }

    public List<Visit> findByDate(LocalDate dateOfVisit) {
        return visitRepository.findByDateOfVisitOrderByTimeOfVisit(dateOfVisit);
    }

    public List<Visit> findByDateAndTime(LocalDate dateOfVisit, LocalTime timeOfVisit) {
        return visitRepository.findByDateOfVisitAndTimeOfVisit(dateOfVisit, timeOfVisit);
    }

    public List<Visit> findByDateBetween(LocalDate dateOfVisit1, LocalDate dateOfVisit2) {
        return visitRepository.findByDateOfVisitBetweenOrderByDateOfVisit(dateOfVisit1, dateOfVisit2);
    }

    public  List<Visit> findByPatient(Patient patient) {
        return visitRepository.findByPatient(patient);
    }

    public  List<Visit> findByPatientByFullName(String firstName, String lastName) {
        return visitRepository.findByPatientFirstNameAndPatientLastName(firstName, lastName);
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
    public  List<Visit> findBySpecialistByFullName(String firstName, String lastName) {
        return visitRepository.findBySpecialistFirstNameAndSpecialistLastName(firstName, lastName);
    }

}
