package io.sekiro.springdatajdbc.tennis_player;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext
    EntityManager em;

    public Player insertPlayer(Player player) {
        return em.merge(player);
    }

    public Player updatePlayer(Player player) {
        return em.merge(player);
    }

    public Player getPlayerById(int id) {
        return em.find(Player.class, id);
    }

    public void deletePlayerById(int id) {
        Player player = em.find(Player.class, id);
        em.remove(player);
    }

    public List<Player> getAllPlayers() {
        TypedQuery<Player> getAll = em.createNamedQuery("get_all_players", Player.class);
        return getAll.getResultList();
    }

}
