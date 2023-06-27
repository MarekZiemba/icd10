package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Size(max = 600)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Treatment treatment;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialist specialist;

}
