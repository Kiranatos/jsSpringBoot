package net.kiranatos.util.bidir.mto;

import java.util.ArrayList;
import java.util.List;
import net.kiranatos.model.bidir.mto.Account;
import net.kiranatos.model.bidir.mto.User;
import net.kiranatos.services.bidir.mto.AccountService;
import net.kiranatos.services.bidir.mto.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsBankAccountsAndUsers implements CommandLineRunner {

    private final AccountService accountService;
    private final UserService userService;

    private final String[] arrUsers = new String[]{"Marina", "John", "Emily", "Richard", "Sophia", "David", "Olivia", "William"};
    private final String[] arrBankNames = {"Sapphire Bank", "Crestview Banking", "First Capital Bank", "Atlantic Union Bank", "Peak Finance", "Sunrise Financial",
        "Golden Key Bank", "Citadel Trust", "Liberty Savings", "Everest Bank", "Union Finance", "Meridian Banking", "Phoenix Wealth",
        "Vanguard Trust", "Pioneer Credit Union", "Royal Bank of Commerce", "First Horizon", "Pacific Crest", "Prospect Bank", "Prestige Finance"
    };

    public InitiateUtilsBankAccountsAndUsers(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Bidirectional association | Account and User entities >>> ");

        List<User> users = new ArrayList<>();
        for (String name : arrUsers) {
            User user = new User();
            user.setName(name);
            users.add(user);
        }
        userService.saveAll(users);

        List<Account> accounts = new ArrayList<>();
        for (String name : arrBankNames) {
            Account acc = new Account();
            acc.setName(name);
            acc.setAmount(getRandomFromZeroToN(10000));
            acc.setUser(getRandomUser());
            accounts.add(acc);
        }
        
        accountService.saveAll(accounts);  
        
        System.out.println(accountService.findByUserName("John").size());
        //accountService.findByUserName("John").size();
        
        for (User u : users) {            
            u.setAccounts(
                    accountService.findByUserName(u.getName())            
            );  
            
            System.out.println(u);
        }
    }

    private static int getRandomFromZeroToN(int n) {
        return (int) (Math.random() * n);
    }

    private static <T> T getRandomElementFromMatrix(T[] matrix) {
        int index = (int) (Math.random() * matrix.length);
        return matrix[index];
    }

    private User getRandomUser() {
        List<User> list = new ArrayList<>();
        do {
            String nameUser = getRandomElementFromMatrix(arrUsers);
            list = userService.findByName(nameUser);
        } while (list.isEmpty());

        return list.get(0);
    }
}
