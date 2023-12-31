package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "specializations")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String name;

    @OneToMany(mappedBy = "specialization")
    @ToString.Exclude
    private Set<Specialist> specialists ;

    public void removeAllSpecialists() {
        for (Specialist specialist : specialists) {
            specialist.setSpecialization(null);
        }
        specialists.clear();
    }

}
