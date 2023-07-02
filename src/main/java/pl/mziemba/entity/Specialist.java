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

////    @NotNull
//    @ManyToMany(cascade = CascadeType.REMOVE)
//    private Set<Patient> patients = new HashSet<>();

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Specialization specialization;

//    Specialista nie wie o Visit (USUWAM TO 2023-07-01)
//    @OneToMany(cascade = CascadeType.REMOVE)
//    @JoinColumn(name="specialist_id")
//    private List<Visit> visits = new ArrayList<>();

//    Specialista nie wie o Treatment
//    @ManyToMany(cascade = CascadeType.REMOVE)
//    private Set<Treatment> treatments = new HashSet<>();

    // dziala kasowanie specjalisty z usera, Specjalista nic nie wie o Userach
//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "id", unique=true)
//    private User user = new User();

    public String getFullName() {
        return firstName + " " + lastName;
    }

//    @PreRemove
//    public void removeAllPatients() {
//        for (Patient patient : patients) {
//            patient.getSpecialists().remove(this);
//        }
//        patients.clear();
//    }
//
//    public void removeSpecialization() {
////        specialization.getSpecialists().remove(this);
//        if (specialization != null) {
//            specialization.getSpecialists().remove(this);
//            specialization = null;
//
//        }
//    }



}
