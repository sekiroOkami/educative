package io.sekiro.springdatajdbc.tennis_player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication  implements CommandLineRunner{

	@Autowired
	private PlayerRepository repo;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		insert();
//		remove();
		getAll();
	}
	private void remove() {
		//inset player
		logger.info("\n\n>> Inserting player: {}", repo.insertPlayer(
				new Player(1,"Marika", "Land between", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("\n\n>> Inserting player: {}", repo.insertPlayer(
				new Player(2,"Radagon", "Leyndell", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("\n\n>> Inserting player: {}", repo.insertPlayer(
				new Player(3,"Radahn", "calid", Date.valueOf("1234-05-06"), 80)
		));

		// update
		logger.info("\n\n>> Updating player: {}", repo.updatePlayer(
				new Player(3,"Ranni", "Caria", Date.valueOf("1234-05-06"), 80)
		));

		logger.info("\n\n>> get player: {}", repo.getPlayerById(
				3
		));
		//delete
		repo.deletePlayerById(3);
	}

	private void insert() {
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player(1,"Marika", "Land between", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player(2,"Radagon", "Lenydell", Date.valueOf("1986-09-01"), 10)));
		logger.info("\n\n>> Player with id 2: {}\n", repo.getPlayerById(2));
	}

	private void getAll() {
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player(1,"Marika", "Land between", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
				new Player(2,"Radagon", "Lenydell", Date.valueOf("1986-09-01"), 10)));

		logger.info("\n\n>> Inserting player: {}\n", repo.insertPlayer(
				new Player(3,"Radahn", "calid", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("\n\nAll player: {}", repo.getAllPlayers());
	}

}
