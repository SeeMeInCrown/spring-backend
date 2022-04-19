package net.conferencescheduling.spring;

import net.conferencescheduling.spring.model.entity.Presenter;
import net.conferencescheduling.spring.repository.PresenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	PresenterRepository presenterRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(presenterRepository.getPresenterById(172966L));
		System.out.println(presenterRepository.findPresenterByName("berke"));
	}

}
