package br.v3rso.amadeus.server;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.soap.client.GetCountryRequest;
import com.example.soap.client.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
}
