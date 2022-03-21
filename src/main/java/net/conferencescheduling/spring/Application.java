package net.conferencescheduling.spring;

import net.conferencescheduling.spring.entity.User;
import net.conferencescheduling.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1= User.builder()
				.firstName("Berke")
				.lastName("Ayan")
				.email("berkeayan@gmail.com")
				.build();
		User user2= User.builder()
				.firstName("Kubra")
				.lastName("Bal")
				.email("kubrabal@gmail.com")
				.build();
		User user3= User.builder()
				.firstName("Buse")
				.lastName("Irican")
				.email("buseirican@gmail.com")
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
	}

}
