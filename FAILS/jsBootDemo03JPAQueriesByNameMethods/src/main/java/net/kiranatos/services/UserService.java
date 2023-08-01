package net.kiranatos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.kiranatos.model.User;
import net.kiranatos.repositories.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}
