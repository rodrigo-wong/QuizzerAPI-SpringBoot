package com.rodrigo.quizzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication
public class QuizzerApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		String databaseUrl = dotenv.get("DB_URL");
		String databaseUsername = dotenv.get("DB_USERNAME");
		String databasePassword = dotenv.get("DB_PASSWORD");
		assert databaseUrl != null;
		System.setProperty("DB_URL", databaseUrl);
		assert databaseUsername != null;
		System.setProperty("DB_USERNAME", databaseUsername);
		assert databasePassword != null;
		System.setProperty("DB_PASSWORD", databasePassword);
		SpringApplication.run(QuizzerApplication.class, args);
	}

}
