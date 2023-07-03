package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.PESEL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "specialists")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Specialist {
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

//    @NotNull
    @ManyToMany(mappedBy = "specialists")
    @ToString.Exclude
    private Set<Patient> patients;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specialization;

    @ManyToMany(mappedBy = "specialists")
    @ToString.Exclude
    private Set<Treatment> treatments;

    @OneToOne(mappedBy = "specialist")
    @ToString.Exclude
    private User user;

    @OneToMany(mappedBy = "specialist")
    @ToString.Exclude
    private Set<Visit> visits;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void removeAllPatients() {
        for (Patient patient : patients) {
            patient.getSpecialists().remove(this);
        }
        patients.clear();
    }

    public void removeAllTreatments() {
        for (Treatment treatment : treatments) {
            treatment.getSpecialists().remove(this);
        }
        treatments.clear();
    }

    public void removeUser () {
        if (user != null) {
            user.setSpecialist(null);
            user = null;
        }

    }
    public void removeAllVisits() {
        for (Visit visit : visits) {
            visit.setSpecialist(null);
        }
        visits.clear();
    }

}
