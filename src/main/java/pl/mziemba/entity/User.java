package pl.mziemba.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "{password.invalid.error}")
    private String password;

    @Column
//    @NotBlank(message = "{not.empty.error}")
    @Size(min = 8, message = "{too.short.error}")
    private String newPassword;

//    @Column(nullable = false)
    private int enabled;

    @OneToOne
    private Specialist specialist;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    public void removeSpecialist() {
        if (specialist != null) {
            specialist.setUser(null);
            specialist = null;
        }
    }

    public void removeRoles() {
        for (Role role: roles) {
            role.getUsers();
        }
        roles.clear();
    }

}
