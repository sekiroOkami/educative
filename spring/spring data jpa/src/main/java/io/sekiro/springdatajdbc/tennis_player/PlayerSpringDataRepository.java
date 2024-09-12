package io.sekiro.springdatajdbc.tennis_player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerSpringDataRepository extends JpaRepository<Player, Long> {
//    public List<Player> findByNationality(String nationality);
}
