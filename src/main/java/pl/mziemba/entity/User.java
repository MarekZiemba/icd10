package pl.mziemba.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String username;

    private String password;

    private int enabled;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialist specialist;

    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}


