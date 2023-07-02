package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Diagnosis;
import pl.mziemba.entity.Patient;
import pl.mziemba.repository.DiagnosisRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DiagnosisService {

    public final DiagnosisRepository diagnosisRepository;

    public void save(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    public void update(Diagnosis diagnosis){
        diagnosisRepository.save(diagnosis);
    }

    public void deleteById(Long id){
        Diagnosis diagnosis = diagnosisRepository.findById(Diagnosis.class, id);
        diagnosis.removeAllPatients();
        diagnosisRepository.deleteById(id);
    }

    public List<Diagnosis> findAll() {
        return diagnosisRepository.findAll();
    }

    public Diagnosis findById(Long id) {
        return diagnosisRepository.findById(id).get();
    }

    public List<Diagnosis> findByName(String name) {
        return diagnosisRepository.findByName(name);
    }

    
}
