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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Patient> patients = new HashSet<>();

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specialization;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        patient.getSpecialists().remove(this);
    }

}
