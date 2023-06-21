package pl.mziemba.entity;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.pl.PESEL;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Patient {
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

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories = new ArrayList<>();

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Specialist> specialists = new ArrayList<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Insurance insurance;

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
