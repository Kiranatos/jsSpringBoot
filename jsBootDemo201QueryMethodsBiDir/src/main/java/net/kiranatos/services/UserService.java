package net.kiranatos.services;

import java.util.List;
import java.util.Set;
import net.kiranatos.model.User;
import net.kiranatos.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }
    
    public void saveAll(Set<User> users) { // {2}
    //public void saveAll(List<User> users) {        
        userRepository.saveAll(users);
    }
    
    public User findByName(String userName) {
        return userRepository
                .findFirstByName(userName)
                .get();
    }
    
    /* ============= Demonstration #4 ============= */
    public List<User> findDistinctUserByAccountsNameContaining(String name) {
        return userRepository.findDistinctUserByAccounts_NameContaining(name);        
    }
    
    /* ============= Demonstration #5 ============= */
    public List<User> findUsersStarsWithName(String partOfName) {
        return userRepository.findByNameIsStartingWith(partOfName);
        //return userRepository.findByNameStartingWith(partOfName);
        //return userRepository.findByNameStartsWith(partOfName);
        //return userRepository.findDistinctByNameStartsWith(partOfName);
        //return userRepository.findDistinctEntitiesByNameStartsWith(partOfName);        
    }
    
    /* ============= Demonstration #5 ============= */
    public List<User> findUsersWhoseAccountStarsWithName(String partOfName) {
        return userRepository.findByAccounts_NameIsStartingWith(partOfName);
        //return userRepository.findDistinctUByAccounts_NameIsStartingWith(partOfName);
    }
    
    /* ============= Demonstration #6 ============= */
    public List<User> findUsersOlderThan(int n) {
        return userRepository.findByYearsIsGreaterThan(n);        
    }
    
    /* ============= Demonstration #6 ============= */
    public List<User> findUsersWhoseAccountHigherThan(long n) {
        //return userRepository.findDistinctByAccounts_AmountIsGreaterThan(n);        
        //return userRepository.findByAccounts_AmountIsGreaterThan(n);
        return userRepository.findWORDDistinctWORDByAccounts_AmountIsGreaterThan(n);
    }
}
