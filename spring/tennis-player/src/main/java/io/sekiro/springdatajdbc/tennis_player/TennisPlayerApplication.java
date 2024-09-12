package io.sekiro.springdatajdbc.tennis_player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerDao dao;

	@Override
	public void run(String... args) throws Exception {
//		insert();
//		update();
//		delete();
		getByCustom();
	}

	private void getByCustom() {
		logger.info("French players: {}", dao.getPlayerByNationality("France"));
	}

	private void delete() {
		logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));
		logger.info("All Players Data: {}", dao.getAllPlayers());
	}

	private void update() {
		logger.info("Inserting Player 4: {}",dao.insertPlayer(
				new Player(4, "Ranni", "Land between",
						new Date((System.currentTimeMillis())), 17
				)));
		logger.info("Updating Player with id 4: {}", dao.updatePlayer(
				new Player(4, "Rennala", "Caria", Date.valueOf("1999-03-19"), 17)
		));
		logger.info("All player: {}" , dao.getAllPlayers());
	}

	private void insert() {
		logger.info("Inserting Player 4: {}",dao.insertPlayer(
				new Player(4, "Ranni", "Land between",
					new Date((System.currentTimeMillis())), 17
				)));
		logger.info("All player: {}" , dao.getAllPlayers());
	}

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

}
