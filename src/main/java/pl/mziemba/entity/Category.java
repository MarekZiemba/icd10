package pl.mziemba.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "categories")
@Setter
@Getter
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String name;

    @Size(max = 600)
    private String evaluationCriteria;

    @Size(max = 600)
    private String description;

}
