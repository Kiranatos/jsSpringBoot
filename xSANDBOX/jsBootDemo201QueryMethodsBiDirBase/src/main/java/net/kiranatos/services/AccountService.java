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
}
