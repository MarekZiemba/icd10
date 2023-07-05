package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "treatments")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String name;

    @Size(max = 600)
    private String description;

//    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Specialist> specialists = new HashSet<>();

    @OneToMany(mappedBy = "treatment")
    @ToString.Exclude
    private Set<Visit> visits;

    public void removeAllSpecialists() {
        for (Specialist specialist : specialists) {
        specialist.getTreatments().remove(this);
        }
        specialists.clear();
    }

    public void removeAllVisits() {
        for (Visit visit : visits) {
            visit.setTreatment(null);
        }
        visits.clear();
    }


}
