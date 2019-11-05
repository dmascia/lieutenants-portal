package com.davemascia.lieutenants;

import com.davemascia.lieutenants.Model.Lieutenant;
import com.davemascia.lieutenants.Model.Lifter;
import com.davemascia.lieutenants.Repository.LieutenantRepository;
import com.davemascia.lieutenants.Repository.LifterRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(LifterRepository lifterRepository,
                                      LieutenantRepository lieutenantRepository,
                                      @Value("${init.loadData}") boolean loadData) {
		return (args) -> {
			if (loadData) {
				Faker faker = new Faker();

                Lieutenant lt1 = new Lieutenant();
                lt1.setFirstName(faker.name().firstName());
                lt1.setLastName(faker.name().lastName());
                lt1.setEmail(faker.internet().emailAddress());
                lt1.setPhone(faker.phoneNumber().cellPhone());
                lt1.setPassword(faker.internet().password());
                lieutenantRepository.save(lt1);

                Lieutenant lt2 = new Lieutenant();
                lt2.setFirstName(faker.name().firstName());
                lt2.setLastName(faker.name().lastName());
                lt2.setEmail(faker.internet().emailAddress());
                lt2.setPhone(faker.phoneNumber().cellPhone());
                lt2.setPassword(faker.internet().password());
                lieutenantRepository.save(lt2);

                Lieutenant lt3 = new Lieutenant();
                lt3.setFirstName(faker.name().firstName());
                lt3.setLastName(faker.name().lastName());
                lt3.setEmail(faker.internet().emailAddress());
                lt3.setPhone(faker.phoneNumber().cellPhone());
                lt3.setPassword(faker.internet().password());
                lieutenantRepository.save(lt3);

                Lieutenant lt4 = new Lieutenant();
                lt4.setFirstName(faker.name().firstName());
                lt4.setLastName(faker.name().lastName());
                lt4.setEmail(faker.internet().emailAddress());
                lt4.setPhone(faker.phoneNumber().cellPhone());
                lt4.setPassword(faker.internet().password());
                lieutenantRepository.save(lt4);

                List<Lieutenant> lieutentant = new ArrayList<>();
                lieutentant.add(lt1);
                lieutentant.add(lt2);
                lieutentant.add(lt3);
                lieutentant.add(lt4);

                Random random = new Random();

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
					lifter.setLieutenant(lieutentant.get(random.nextInt(4)));
					lifterRepository.save(lifter);
				}
			}
		};
	}
}
