package pl.mziemba.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="role_id")
//    private List<User> users = new ArrayList<>();
}

