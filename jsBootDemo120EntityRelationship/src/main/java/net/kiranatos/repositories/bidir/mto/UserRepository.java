package net.kiranatos.repositories.bidir.mto;

import java.util.List;
import net.kiranatos.model.bidir.mto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findByName(String name);

}
