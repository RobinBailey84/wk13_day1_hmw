package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createSinglePirateAndSave(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate);
	}

	@Test
	public void createPirateAndShip() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
	}

	@Test
	public void addPirateToRaid() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
		Raid raid = new Raid("Glasgow", 10);
		raid.addPirateToRaid(pirate1);
		raidRepository.save(raid);
		}

	@Test
	public void addRaidToPirate() {
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);
		Raid raid = new Raid("Glasgow", 10);
		raidRepository.save(raid);
		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirate1.addRaidToPirate(raid);
		pirateRepository.save(pirate1);
	}
}
