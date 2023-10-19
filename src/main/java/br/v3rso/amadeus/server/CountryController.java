package br.v3rso.amadeus.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.soap.client.GetCountryResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class CountryRequest {
    String name;

    @JsonCreator
    public CountryRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class CountryResponse {
    String name;
    int population;
    String capital;
    String currency;

    @JsonCreator
    CountryResponse(
        @JsonProperty("name") String name, 
        @JsonProperty("population") int population, 
        @JsonProperty("capital") String capital, 
        @JsonProperty("currency") String currency) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }
}

@RestController
public class CountryController {
	@Autowired
    private final CountryClient client;

    CountryController(CountryClient client) {
        this.client = client;
    }

    @PostMapping("/country")
    CountryResponse one(@RequestBody CountryRequest request) {
        GetCountryResponse response = client.getCountry(request.getName());

        return new CountryResponse(
            response.getCountry().getName(),
            response.getCountry().getPopulation(),
            response.getCountry().getCapital(),
            response.getCountry().getCurrency().toString()
        );
    }

}
