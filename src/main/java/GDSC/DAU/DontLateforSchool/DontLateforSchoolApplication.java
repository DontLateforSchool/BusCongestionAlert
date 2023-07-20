package GDSC.DAU.DontLateforSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableJpaAuditing
public class DontLateforSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DontLateforSchoolApplication.class, args);
	}

}
