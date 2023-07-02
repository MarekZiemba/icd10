package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "visits")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "{not.empty.error}")
    @Column(name = "dateOfVisit")
    private LocalDate dateOfVisit;

//    @NotBlank(message = "{not.empty.error}")
    @Column(name = "timeOfVisit")
    private LocalTime timeOfVisit;

    @Size(max = 6400)
    private String description;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "patient_id")
    private Patient patient;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

//    @PreRemove
    //(USUWAM TO 2023-07-01)
//    public void removeSpecialist() {
////        specialist.getVisits().remove(this);
//        if (specialist != null) {
//            specialist.getVisits().remove(this);
//            specialist = null;
//        }
//    }

//    public void removePatient() {
//        if (patient != null) {
//            patient.getVisits().remove(this);
//            patient = null;
//        }
//        patient.getVisits().remove(this);
//    }

//    (USUWAM TO 2023-07-01)
//    public void removeTreatment() {
////        treatment.getVisits().remove(this);
//        if (treatment != null) {
//            treatment.getVisits().remove(this);
//            treatment = null;
//        }
//    }

//    (USUWAM TO 2023-07-01)
//    public void removePatient() {
//        if (patient != null) {
//            patient.getVisits().remove(this);
//            patient = null;
//        }
//    }



}
