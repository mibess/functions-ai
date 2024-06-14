package dev.mibess.functions.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("weather")
public record WeatherConfigProperties(String apiKey, String apiUri) {

}
