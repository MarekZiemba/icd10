package pl.mziemba.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.mziemba.entity.Specialist;
import pl.mziemba.entity.User;
import pl.mziemba.service.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoggedInUserDetails {
    private final UserService userService;

    public String getLoggedInUserFullName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<User> users = userService.findByUsername(username);
            User user = users.isEmpty() ? null : users.get(0);
            if (user != null && user.getSpecialist() != null) {
                Specialist specialist = user.getSpecialist();
                return specialist.getFirstName() + " " + specialist.getLastName();
            }
        }
        return null;
    }

    public String getLoggedInSpecialistId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            List<User> users = userService.findByUsername(username);
            User user = users.isEmpty() ? null : users.get(0);
            if (user != null && user.getSpecialist() != null) {
                Specialist specialist = user.getSpecialist();
                return String.valueOf(specialist.getId());
            }
        }
        return null;
    }
}
