package net.kiranatos.services.bidir.mto;

import java.util.List;
import net.kiranatos.model.bidir.mto.Account;
import net.kiranatos.repositories.bidir.mto.AccountRepository;
import org.springframework.stereotype.Service;

@Service

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void saveAll(List<Account> accounts) {
        accountRepository.saveAll(accounts);
    }
    
    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findById(Long id) {
        return accountRepository.findAccountById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
    }
    
    public List<Account> findByUserName(String name) {
        return accountRepository.findAccountByUserName(name);
    }
}


