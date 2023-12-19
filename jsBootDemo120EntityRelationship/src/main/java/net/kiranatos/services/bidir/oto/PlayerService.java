package net.kiranatos.services.bidir.oto;

import net.kiranatos.model.bidir.oto.Player;
import net.kiranatos.repositories.bidir.oto.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void save(Player player) {
        playerRepository.save(player);
    }
}
