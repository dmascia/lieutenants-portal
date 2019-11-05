package com.davemascia.lieutenants;

import com.davemascia.lieutenants.Model.Lifter;
import com.davemascia.lieutenants.Repository.LifterRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(LifterRepository lifterRepository, @Value("${init.loadData}") boolean loadData) {
		return (args) -> {
			if (loadData) {
				Faker faker = new Faker();

				for (int i = 0; i <= 200; i++) {
					Lifter lifter = new Lifter();
					lifter.setFirstName(faker.name().firstName());
					lifter.setLastName(faker.name().lastName());
					lifter.setEmail(faker.internet().emailAddress());
					lifter.setCity(faker.address().city());
					lifter.setState(faker.address().state());
					lifter.setStreet(faker.address().streetAddress());
					lifter.setZip(faker.address().zipCode());
					lifter.setPhone1(faker.phoneNumber().cellPhone());
					lifter.setTshirtSize(Lifter.Size.FOUR_XL);
					lifter.setRemoved(false);
					lifter.setNotLifter(false);
					lifterRepository.save(lifter);
				}
			}
		};
	}
}
