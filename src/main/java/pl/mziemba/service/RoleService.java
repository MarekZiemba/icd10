package pl.mziemba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mziemba.entity.Role;
import pl.mziemba.entity.User;
import pl.mziemba.repository.RoleRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void update(Role role){
        roleRepository.save(role);
    }

    public void deleteById(Long id){
        Role role = roleRepository.findById(Role.class, id);
        role.removeUser();
        roleRepository.deleteById(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    public List<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

}