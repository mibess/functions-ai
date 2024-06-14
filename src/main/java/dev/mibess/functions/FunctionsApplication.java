package dev.mibess.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.mibess.functions.configs.WeatherConfigProperties;

@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class FunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionsApplication.class, args);

		// Fonte do Projeto
		// Spring AI Functions - How to register custom Java functions with the Chat
		// Client
		// https://www.youtube.com/watch?v=n7IvE1VSbvI&list=PLZV0a2jwt22uoDm3LNDFvN6i2cAVU_HTH&index=7
		// Dan Vega
	}

}
