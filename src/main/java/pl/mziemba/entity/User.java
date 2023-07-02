package pl.mziemba.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    @Column(nullable = false, unique = true, length = 60)
    private String username;

    @NotBlank(message = "{not.empty.error}")
    @Size(min = 2, message = "{too.short.error}")
    private String password;

    private int enabled;

//    @NotEmpty
    @OneToOne
//    @JoinColumn(name = "specialistt_id")
//    @OneToOne(cascade = CascadeType.REMOVE) (USUWAM TO 2023-07-01)
//    @JoinColumn(name = "specialist_id", unique=true) (USUWAM TO 2023-07-01)
    private Specialist specialist;

//    @NotEmpty
//    @ManyToOne(fetch = FetchType.LAZY) (USUWAM TO 2023-07-01)
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    private Role role;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Role> roles;

    // dziala kasowanie specjalisty z usera, Specjalista nic nie wie o Userach (USUWAM TO 2023-07-01)
//    public void removeSpecialist() {
//        if (specialist != null) {
//            specialist.getUser().remove(this);
//            specialist = null;
//        }
//    }

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}


