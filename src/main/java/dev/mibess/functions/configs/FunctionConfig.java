package dev.mibess.functions.configs;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import dev.mibess.functions.dtos.WeatherDTO;
import dev.mibess.functions.dtos.WeatherInput;
import dev.mibess.functions.services.WeatherService;

@Configuration
public class FunctionConfig {

    private final WeatherConfigProperties weatherConfigProperties;

    public FunctionConfig(WeatherConfigProperties weatherConfigProperties) {
        this.weatherConfigProperties = weatherConfigProperties;
    }

    @Bean
    @Description("Get the current weather conditions for the given city")
    public Function<WeatherInput, WeatherDTO> currentWeatherFunction() {
        return new WeatherService(weatherConfigProperties);
    }

}
