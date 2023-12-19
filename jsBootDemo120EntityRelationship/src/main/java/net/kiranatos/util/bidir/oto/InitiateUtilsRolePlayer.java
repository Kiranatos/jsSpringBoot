package net.kiranatos.util.bidir.oto;

import net.kiranatos.model.bidir.oto.Player;
import net.kiranatos.model.bidir.oto.Role;
import net.kiranatos.services.bidir.oto.PlayerService;
import net.kiranatos.services.bidir.oto.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class InitiateUtilsRolePlayer implements CommandLineRunner {

    private final PlayerService playerService;
    private final RoleService roleService;

    public InitiateUtilsRolePlayer(PlayerService playerService, RoleService roleService) {
        this.playerService = playerService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" <<< Bidirectional association | Role and Player entities >>> ");

        String[] arrRole = new String[]{"Magician", "Wizard", "Thief", "Tank", "Warrior", "Ranger", "Bard", "Fighter", "Healer", "Destroyer", "Archer", "Blade master"};

        String[] arrPlayer = new String[]{"Marina", "John", "Emily", "Richard", "Sophia", "David", "Olivia", "William"};

        int n = arrRole.length > arrPlayer.length ? arrPlayer.length : arrRole.length;

        init(arrRole, arrPlayer, n);
        //initForCascadeParametr(arrRole, arrPlayer, n);
    }

    private void init(String[] arrRole, String[] arrPlayer, int n) {
        for (int i = 0; i < n; i++) {
            Role r = new Role();
            r.setName(arrRole[i]);
            roleService.save(r);

            Player p = new Player();
            p.setName(arrPlayer[i]);
            p.setRole(r);

            playerService.save(p);

            r.setPlayer(p);
        }
    }

    private void initForCascadeParametr(String[] arrRole, String[] arrPlayer, int n) {
        for (int i = 0; i < n; i++) {
            Player p = new Player();
            p.setName(arrPlayer[i]);

            Role r = new Role();
            r.setName(arrRole[i]);

            p.setRole(r);
            r.setPlayer(p);

            roleService.save(r);
            playerService.save(p);
        }
    }
}
