package net.kiranatos.repositories.bidir.oto;

import net.kiranatos.model.bidir.oto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
