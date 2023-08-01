package net.kiranatos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import net.kiranatos.model.Account;
import net.kiranatos.model.User;
import net.kiranatos.services.AccountService;
import net.kiranatos.services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final AccountService accountService;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< CommandLineRunner from Spring Boot Demo03 Application >>> ");
        
        Account ac0 = new Account().setName("Privat-Bank").setAmount(100);
        Account ac1 = new Account().setName("Alpha-Bank").setAmount(44100);
        Account ac2 = new Account().setName("Beta-Bank").setAmount(9100);
        Account ac3 = new Account().setName("Alpha-Bank").setAmount(8100);
        Account ac4 = new Account().setName("USA-Bank").setAmount(10000);
        Account ac5 = new Account().setName("Cuprus-Bank").setAmount(11100);
        Account ac6 = new Account().setName("Alpha-Bank").setAmount(1040);
        Account ac7 = new Account().setName("Alpha-Bank").setAmount(4100);
        Account ac8 = new Account().setName("Beta-Bank").setAmount(2100);
        Account ac9 = new Account().setName("Privat-Bank").setAmount(1000);
        
        User user0 = new User().setName("Marta").setAccounts(toSet(ac0,ac1));
        User user1 = new User().setName("Bill").setAccounts(toSet(ac2));
        User user2 = new User().setName("Oleg").setAccounts(toSet(ac3,ac4,ac5));
        User user3 = new User().setName("Cassandra").setAccounts(toSet(ac6));
        User user4 = new User().setName("Oleg").setAccounts(toSet(ac7,ac8));
        User user5 = new User().setName("Denny").setAccounts(toSet(ac9));
        
//        ac0.setUser(user0);
//        ac1.setUser(user0);
//        ac2.setUser(user1);
//        ac3.setUser(user2);
//        ac4.setUser(user2);
//        ac5.setUser(user2);
//        ac6.setUser(user3);
//        ac7.setUser(user4);
//        ac8.setUser(user4);
//        ac9.setUser(user5);
        
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        
        List<Account> accounts = new ArrayList<>();
        accounts.add(ac0);
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        accounts.add(ac5);
        accounts.add(ac6);
        accounts.add(ac7);
        accounts.add(ac8);
        accounts.add(ac9);
        
        userService.saveAll(users);
        accountService.saveAll(accounts);
    }
    
    private <T> Set<T> toSet(T... elements) {
        Set<T> set = new HashSet<>();
        set.addAll(Arrays.asList(elements));
        return set;
    }
}
