package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
@Setter
@Getter
@Data
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "{not.empty.error}")
//    @Size(min = 2, message = "{too.short.error}")
    private String name;

//    @Size(max = 2000)
    private String evaluationCriteria;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patients;

    public void removeAllPatients() {
        for (Patient patient : patients) {
            patient.getDiagnoses().remove(this);
        }
        patients.clear();
    }
}
