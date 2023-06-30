package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Specialist;
import pl.mziemba.repository.PatientRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public void update(Patient patient){
        patientRepository.save(patient);
    }

    public void deleteById(Long id){
        // Pobierz pacjenta, którego chcemy usunąć
        Patient patient = patientRepository.findById(Patient.class, id);

        // Usuwamy powiązania pacjenta
        patient.removeAllSpecialists();
        patient.removeAllVisits();
        patient.removeAllDiagnoses();

        // Usuwamy pacjenta
        patientRepository.deleteById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).get();
    }

    public List<Patient> findByFirstNameAndLastName(String firstName, String lastName) {
        return patientRepository.findByFirstNameContainsAndLastNameContains(firstName, lastName);
    }

    public List<Patient> findByDateOfBirth(String dateOfBirth) {
        return patientRepository.findByDateOfBirth(dateOfBirth);
    }
    public List<Patient> findByPesel(String pesel) {
        return patientRepository.findByPesel(pesel);
    }

    public  List<Patient> findByInsurance(String insurance) {
        return patientRepository.findByInsurance(insurance);
    }

    public List<Patient> findByDiagnosisContains(Diagnosis diagnosis) {
        return patientRepository.findByDiagnosesContains(diagnosis);
    }

    public List<Patient> findByDiagnosisNameContains(String name) {
        return patientRepository.findByDiagnosesNameContains(name);
    }

    public List<Patient> findBySpecialist(Specialist specialist) {
        return patientRepository.findBySpecialistsContains(specialist);
    }

    public List<Patient> findBySpecialistFullName(String firstName, String lastName) {
        return patientRepository.findBySpecialistsFirstNameAndSpecialistsLastName(firstName, lastName);
    }

}
