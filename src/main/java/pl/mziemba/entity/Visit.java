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
    private String timeOfVisit;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialist specialist;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    @Size(max = 600)
    private String description;

}
