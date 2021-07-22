package curso.aws.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan("curso.aws.tutorial")
@EnableWebFlux
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

}
