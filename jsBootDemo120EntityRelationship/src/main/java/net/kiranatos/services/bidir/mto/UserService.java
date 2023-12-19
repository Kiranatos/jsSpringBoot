package net.kiranatos.services.bidir.mto;

import java.util.List;
import net.kiranatos.model.bidir.mto.User;
import net.kiranatos.repositories.bidir.mto.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }
    
    public List<User> findByName(String name) {
        List<User> list = userRepository.findByName(name);
        
        return list;
    }    
}
