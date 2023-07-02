package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @ManyToMany(cascade = CascadeType.REMOVE)
//    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "treatments")
    private Set<Specialist> specialists = new HashSet<>();

    //nie wie, że jest w Wizytach (USUWAM TO 2023-07-01)
//    @OneToMany(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "treatment_id")
//    private List<Visit> visits = new ArrayList<>();


//    public void removeAllVisits() {
//        for (Visit visit : visits) {
//            visit.setPatient(null);
//        }
//        visits.clear();
//    }

}
