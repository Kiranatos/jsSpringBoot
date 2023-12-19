package net.kiranatos.repositories.bidir.mto;

import java.util.List;
import java.util.Optional;
import net.kiranatos.model.bidir.mto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
   
    Optional<Account> findAccountById(Long id);
    
    List<Account> findAccountByUserName(String name);
}
