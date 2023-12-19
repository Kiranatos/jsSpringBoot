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
}
