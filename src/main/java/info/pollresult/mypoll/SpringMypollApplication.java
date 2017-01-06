package info.pollresult.mypoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("info.pollresult.mypoll.repository")
public class SpringMypollApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMypollApplication.class, args);
	}
}
