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

//    @NotBlank(message = "{not.empty.error}")
//    @Size(min = 2, message = "{too.short.error}")
//    @Column(nullable = false, unique = true, length = 60)
    private String username;

//    @NotBlank(message = "{not.empty.error}")
//    @Size(min = 2, message = "{too.short.error}")
    private String password;

    private int enabled;

//    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialist specialist;

//    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = JoinColumn(name = "role_id"))
//    private Set<Role> roles;

}


