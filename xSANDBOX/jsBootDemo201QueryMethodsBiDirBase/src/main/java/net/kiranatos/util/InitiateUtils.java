package net.kiranatos.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.kiranatos.model.Account;
import net.kiranatos.model.User;
import net.kiranatos.services.AccountService;
import net.kiranatos.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtils implements CommandLineRunner {

    private final AccountService accountService;
    private final UserService userService;

    private final String[] arrUsers = new String[]{"Marina", "John", "Emily", "Richard", "Sophia", "David", "Olivia", "William"};
    private final String[] arrBankNames = {"Sapphire Bank", "Crestview Banking", "First Capital Bank", "Atlantic Union Bank", "Peak Finance", "Sunrise Financial",
        "Golden Key Bank", "Citadel Trust", "Liberty Savings", "Everest Bank", "Union Finance", "Meridian Banking", "Phoenix Wealth",
        "Vanguard Trust", "Pioneer Credit Union", "Royal Bank of Commerce", "First Horizon", "Pacific Crest", "Prospect Bank", "Prestige Finance"
    };

    public InitiateUtils(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Bidirectional association | Account and User entities >>> ");
        
        Set<User> users = new HashSet<>(); // {2}
        //List<User> users = new ArrayList<>();
        for (String name : arrUsers) {
            User user = new User();
            user.setName(name);
            users.add(user);
        }
        userService.saveAll(users);

        Set<Account> accounts = new HashSet<>(); // {1}
        //List<Account> accounts = new ArrayList<>();
        for (String name : arrBankNames) {
            Account acc = new Account();
            acc.setName(name);
            acc.setAmount(getRandomFromZeroToN(10000));
            acc.setUser(getRandomUser());
            accounts.add(acc);
        }
        
        accountService.saveAll(accounts);

        
    }
    
    private static int getRandomFromZeroToN(int n) {
        return (int) (Math.random() * n);
    }
    
    private static <T> T getRandomElementFromMatrix(T[] matrix) {
        int index = (int) (Math.random() * matrix.length);
        return matrix[index];
    }

    private User getRandomUser() {
        User user;
        do {
            String nameUser = getRandomElementFromMatrix(arrUsers);
            user = userService.findByName(nameUser);
        } while (Objects.isNull(user));

        return user;

//return userService.findByName(getRandomElementFromMatrix(arrUsers));
    }

}
