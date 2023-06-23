package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Patient;
import pl.mziemba.entity.Category;
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

    public List<Patient> findByCategory(Category category) {
        return patientRepository.findByCategoriesContains(category);
    }

    public List<Patient> findByCategoryName(String name) {
        return patientRepository.findByCategoriesNameContains(name);
    }

    public List<Patient> findBySpecialistFullName(String firstName, String lastName) {
        return patientRepository.findBySpecialistsFirstNameAndSpecialistsLastName(firstName, lastName);
    }

}
