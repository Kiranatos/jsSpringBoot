package net.kiranatos.repositories;

import java.util.List;
import net.kiranatos.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    /* ============= Demonstration #4 ============= */
    List<Account> findDistinctAccountByUser_NameContaining(String str);    
    
    /* ============= Demonstration #5 ============= */
    List<Account> findByNameIsStartingWith(String partOfAccountName);   
    List<Account> findByNameStartingWith(String partOfAccountName);
    List<Account> findByNameStartsWith(String partOfAccountName);
    List<Account> findDistinctByNameStartsWith(String partOfAccountName);
    List<Account> findDistinctEntitiesByNameStartsWith(String partOfAccountName);
    
    List<Account> findByUser_NameIsStartingWith(String partOfUserName);
    List<Account> findDistinctAccountByUser_NameIsStartingWith(String partOfUserName);
    
    /* ============= Demonstration #6 ============= */
    List<Account> findAccByAmountIsGreaterThan(Integer n);
    
    List<Account> findDistinctByUser_YearsIsGreaterThan(Integer n);    
    
    

}
