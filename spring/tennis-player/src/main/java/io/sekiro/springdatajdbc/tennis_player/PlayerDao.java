package io.sekiro.springdatajdbc.tennis_player;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {
    private JdbcTemplate jdbcTemplate;

    public static final class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            var player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setNationality(resultSet.getString("nationality"));
            player.setBirthDate(resultSet.getDate("birth_date"));
            player.setTitles(resultSet.getInt("titles"));
            return player;
        }
    }

    public List<Player> getPlayerByNationality(String nationality) {
        String sql = """
                SELECT * FROM Player WHERE nationality = ?
                """;
        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[]{nationality});
    }

    public PlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> getAllPlayers() {
        String sql = """
                SELECT * FROM Player;
                """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayersById(int id) {
        String sql ="""
                SELECT * FROM PLayer WHERE id = ?
                """;
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Player.class),
                new Object[] {id}
                );
    }

    public int insertPlayer(Player player) {
        String sql = """
                INSERT INTO Player (ID, Name, Nationality,Birth_date, Titles) VALUES(?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql,
                new Object[]{player.getId(), player.getName(), player.getNationality(),
                    new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }

    public int updatePlayer(Player player) {
        String sql = """
                UPDATE PLAYER SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? WHERE id = ?;
                """;
        return jdbcTemplate.update(sql, new Object[]{
                player.getName(),
                player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()),
                player.getTitles(),
                player.getId()
        });
    }

    public int deletePlayerById(int id) {
        String sql="DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }
}
