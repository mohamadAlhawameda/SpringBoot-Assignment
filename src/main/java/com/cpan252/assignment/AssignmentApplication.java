package com.cpan252.assignment;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.cpan252.assignment.model.item;
import com.cpan252.assignment.model.item.Anime;
import com.cpan252.assignment.repository.ItemRepository;

@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository) {
		return args -> {
			repository.save(item.builder()
					.name("Heihachi Mishima")
					.brand(Anime.NIKE)
					.prucdedDate(2023)
					.price(2000).build());

			repository.save(item.builder()
					.name("Nike")
					.brand(Anime.NIKE)
					.prucdedDate(2023)
					.price(2000).build());

			repository.save(item.builder()
					.name("Nike")
					.brand(Anime.NIKE)
					.prucdedDate(2023)
					.price(2000).build());

			repository.save(item.builder()
					.name("HM")
					.brand(Anime.NIKE)
					.prucdedDate(2023)
					.price(2000).build());
			repository.save(item.builder()
					.name("HM")
					.brand(Anime.NIKE)
					.prucdedDate(2023)
					.price(2000).build());
		};
	}

}
