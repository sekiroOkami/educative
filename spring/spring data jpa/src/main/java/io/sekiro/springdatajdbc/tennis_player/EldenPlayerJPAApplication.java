package io.sekiro.springdatajdbc.tennis_player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class EldenPlayerJPAApplication implements CommandLineRunner{
	@Autowired
	PlayerSpringDataRepository repo;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(EldenPlayerJPAApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		persist();
		update();
		findById(2L);
//		customFind("Shadow realm");
	}

	private void persist() {
		logger.info("Inserting player: {}",repo.save(
				new Player(1,"Marika", "Land between", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("Inserting player: {}",repo.save(
				new Player(2,"Radagon", "Land between", Date.valueOf("1234-05-06"), 80)
		));
		logger.info("Inserting player: {}",repo.save(
				new Player(3,"Ranni", "Land between", Date.valueOf("1234-05-06"), 80)
		));
	}

	private void update() {
		logger.info("update player: {}",repo.save(
				new Player(3,"Rellana", "Shadow realm", Date.valueOf("1234-05-06"), 80)
		));
	}

	private void findById(Long id) {
		logger.info("Find player by id: {}",repo.findById(id));
	}

	private void findAll() {
		logger.info("Find All: {}",repo.findAll());
	}

	private void customFind(String nationality) {
//		logger.info("Find by Nationality: {}",repo.findByNationality(nationality));
	}
}
