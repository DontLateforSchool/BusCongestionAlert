package GDSC.DAU.DontLateforSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DontLateforSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DontLateforSchoolApplication.class, args);
	}

}
