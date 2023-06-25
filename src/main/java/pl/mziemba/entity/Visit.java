package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @NotBlank(message = "{not.empty.error}")
    private String dateOfVisit;

    @NotBlank(message = "{not.empty.error}")
    private String timeOfVisit;

    @Size(max = 600)
    private String description;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Treatment treatment;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialist specialist;

}
