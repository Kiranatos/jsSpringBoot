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

    private final String[] arrUsers = new String[]{"Marina", "John", "Emily", "Richard", "Sophia", "David", "Olivia", "William", "Daniel", "Darknia", "Dan", "Mark", "Mathew"};
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
        System.out.println("\n\n <<< Bidirectional association | Account and User entities >>>");

        init();
        
        System.out.println("\n ============= Demonstration #1 [ find…By, read…By, get…By, query…By, search…By, stream…By ] ============= ");
        System.out.println("\t Find Peak Finance bank accounts:");
        print(accountService.searchAccountsByName("Peak Finance"));
        String nameOfRandomUser = getRandomUser().getName();
        System.out.println("\t Find <<" + nameOfRandomUser + ">> user: ");
        print(userService.searchStreamUsersByName(nameOfRandomUser));

        System.out.println("\n ============= Demonstration #4 ============= ");
        System.out.println("\tUser who has account in Everest Bank:");
        print(userService.findDistinctUserByAccountsNameContaining("Everest Bank"));

        nameOfRandomUser = getRandomUser().getName();
        System.out.println("\n\t User <<" + nameOfRandomUser + ">> has accounts in next banks: ");
        print(accountService.findDistinctAccByUsersNameContaining(nameOfRandomUser));

        System.out.println("\n ============= Demonstration #5 ============= ");
        System.out.println("\t Accounts in banks that names starts with `P`:");
        print(accountService.findAccountsStarsWithName("P"));
        System.out.println("\n\t Accounts of users whose names starts with `Da`:");
        print(accountService.findAccountsThatUserStarsWithName("Da"));

        System.out.println("\n\t Users whose names starts with `Ma`:");
        print(userService.findUsersStarsWithName("Ma"));
        System.out.println("\n\t Users whose accounts in banks starts with `C`:");
        print(userService.findUsersWhoseAccountStarsWithName("C"));

        System.out.println("\n ============= Demonstration #6 ============= ");
        System.out.println("\t Accounts in banks that have amounts greater then 7000 :");
        print(accountService.findAccountsByAmountIsGreaterThan(7000));
        System.out.println("\n\t Accounts of users whose older than 60:");
        print(accountService.findAccountsThatUsersOlderThan(60));

        System.out.println("\n\t Users who older than 60 :");
        print(userService.findUsersOlderThan(60));
        System.out.println("\n\t Users whose accounts in banks higher than 7000 :");
        print(userService.findUsersWhoseAccountHigherThan(7000));
        
        System.out.println("\n ============= Demonstration #7 AND ============= ");
        System.out.println("\t Find users whose name stars with `M` and older than 50 years.");
        print(userService.findByNameStartsWithAndYearsIsGreaterThan("M", 50));
        System.out.println("\t Find users with name `Darknia` and deposit higher than 1000.");
        print(userService.findByNameAndAmountIsGreaterThan("Darknia", 1000));
        
        System.out.println("\t Find accounts with name stars with `P` and deposit less than 5000.");
        print(accountService.findByNameStartsWithAndAmountLessThan("P", 5000));
        System.out.println("\t Find accounts with deposit higher than 5000 and users name start with `D`.");
        print(accountService.findByAmountIsGreaterThanAndUserNameStartsWith(5000, "D"));
    }

    private static <T> void print(List<T> list) {
        for (T t : list) {
            System.out.println("\t\t " + t);
        }
    }

    private void init() {
        Set<User> users = new HashSet<>(); // {2}
        //List<User> users = new ArrayList<>();
        for (String name : arrUsers) {
            User user = new User();
            user.setName(name);
            user.setYears(18 + getRandomFromZeroToN(75));
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

    private void addUser(String name) {
        addUser(name, 18 + getRandomFromZeroToN(75));
    }

    private void addUser(String name, int years) {
        User user = new User();
        user.setName(name);
        user.setYears(years);
        userService.save(user);
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
    }
}
