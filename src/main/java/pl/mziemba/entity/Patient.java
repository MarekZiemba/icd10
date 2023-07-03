package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.pl.PESEL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "patients")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String firstName;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String lastName;

    @NotBlank(message = "{not.empty.error}")
    private String dateOfBirth;

    @NotBlank(message = "{not.empty.error}")
    @PESEL
    private String pesel;

    @NotNull
    @Size(min = 10, max = 26, message = "{not.between.error}")
    private String insurance;

//    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Diagnosis> diagnoses;

//    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Specialist> specialists;


    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private Set<Visit> visits;

    public String getFullName() {
        return firstName + " " + lastName;
    }

//    public void removeSpecialist(Specialist specialist) {
//        specialists.remove(specialist);
//        specialist.getPatients().remove(this);
//    }

//    @PreRemove
    public void removeAllSpecialists() {
        for (Specialist specialist : specialists) {
            specialist.getPatients().remove(this);
        }
        specialists.clear();
    }

    public void removeAllVisits() {
        for (Visit visit : visits) {
            visit.setPatient(null);
        }
        visits.clear();
    }

    public void removeAllDiagnoses() {
        for (Diagnosis diagnosis: diagnoses) {
            diagnosis.setPatients(null);
        }
        diagnoses.clear();
    }

}
