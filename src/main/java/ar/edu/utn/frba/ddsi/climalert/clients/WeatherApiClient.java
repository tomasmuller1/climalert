package ar.edu.utn.frba.ddsi.climalert.clients;

import ar.edu.utn.frba.ddsi.climalert.dto.weatherapi.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {

    private final RestClient weatherApiRestClient;
    private final String apiKey;

    public WeatherApiClient(RestClient weatherApiRestClient,
                             @Value("${weatherapi.api-key}") String apiKey) {
        this.weatherApiRestClient = weatherApiRestClient;
        this.apiKey = apiKey;
    }

    public WeatherApiResponse obtenerClimaActual(String ubicacion) {
        return weatherApiRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key", apiKey)
                        .queryParam("q", ubicacion)
                        .queryParam("aqi", "no")
                        .build())
                .retrieve()
                .body(WeatherApiResponse.class);
    }
}