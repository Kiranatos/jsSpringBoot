package net.kiranatos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.kiranatos.model.Account;
import net.kiranatos.repositories.AccountRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void saveAll(List<Account> accounts) {
        accountRepository.saveAll(accounts);
    }
}
