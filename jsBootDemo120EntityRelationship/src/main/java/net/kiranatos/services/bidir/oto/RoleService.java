package net.kiranatos.services.bidir.oto;

import net.kiranatos.model.bidir.oto.Role;
import net.kiranatos.repositories.bidir.oto.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void save(Role role) {
        roleRepository.save(role);
    }
}
