package dev.mibess.functions.services;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import dev.mibess.functions.configs.WeatherConfigProperties;
import dev.mibess.functions.dtos.WeatherDTO;
import dev.mibess.functions.dtos.WeatherInput;

@Service
public class WeatherService implements Function<WeatherInput, WeatherDTO> {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherConfigProperties weatherConfigProperties;
    private final RestClient restClient;

    public WeatherService(WeatherConfigProperties weatherConfigProperties) {
        this.weatherConfigProperties = weatherConfigProperties;
        this.restClient = RestClient.create(weatherConfigProperties.apiUri());
    }

    @Override
    public WeatherDTO apply(WeatherInput weatherInput) {
        log.info("Weather api-uri: {}", weatherConfigProperties.apiUri());
        log.info("Weather Request: {}", weatherInput);

        var weatherDTO = restClient.get()
                .uri("/current.json?key={key}&q={q}", weatherConfigProperties.apiKey(), weatherInput.city())
                .retrieve()
                .body(WeatherDTO.class);

        log.info("Weather API Response: {}", weatherDTO);
        return weatherDTO;
    }

}
