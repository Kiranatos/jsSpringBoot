package net.kiranatos.services;

import java.util.List;
import java.util.Set;
import net.kiranatos.model.Account;
import net.kiranatos.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account) {
        accountRepository.save(account);
    }
    
    public void saveAll(Set<Account> accounts) { // {1}
    //public void saveAll(List<Account> accounts) {
        accountRepository.saveAll(accounts);
    }
    
    /* ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= */
    public List<Account> searchAccountsByName(String name) {
        return accountRepository.searchByName(name);                
    }
        
    /* ============= Demonstration #4 ============= */
    public List<Account> findDistinctAccByUsersNameContaining(String name) {
        return accountRepository.findDistinctAccountByUser_NameContaining(name);                
    }
    
    /* ============= Demonstration #5 ============= */
    public List<Account> findAccountsStarsWithName(String partOfName) {
        return accountRepository.findByNameIsStartingWith(partOfName);
        //return accountRepository.findByNameStartingWith(partOfName);
        //return accountRepository.findByNameStartsWith(partOfName);
        //return accountRepository.findDistinctByNameStartsWith(partOfName);
        //return accountRepository.findDistinctEntitiesByNameStartsWith(partOfName);  
    }
    
    /* ============= Demonstration #5 ============= */
    public List<Account> findAccountsThatUserStarsWithName(String partOfName) {
        return accountRepository.findByUser_NameIsStartingWith(partOfName);
        //return accountRepository.findDistinctAccountByUser_NameIsStartingWith(partOfName);    
    }
    
    /* ============= Demonstration #6 ============= */
    public List<Account> findAccountsByAmountIsGreaterThan(int n) {
        return accountRepository.findAccByAmountIsGreaterThan(n);        
    }
        
    /* ============= Demonstration #6 ============= */
    public List<Account> findAccountsThatUsersOlderThan(int n) {
        return accountRepository.findDistinctByUser_YearsIsGreaterThan(n);        
    }
    
    /* ============= Demonstration #7 AND ============= */
    public List<Account> findByNameStartsWithAndAmountLessThan(String firstLetterOfName, int amount) {
        return accountRepository.findDistinctByNameStartsWithAndAmountLessThan(firstLetterOfName, amount);        
    }
    
    public List<Account> findByAmountIsGreaterThanAndUserNameStartsWith(long amount, String firstLetterOfName) {
        return accountRepository.findDistinctByAmountIsGreaterThanAndUser_NameStartsWith(amount, firstLetterOfName);        
    }
}
