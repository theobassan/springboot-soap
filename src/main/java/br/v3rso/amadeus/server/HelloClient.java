package br.v3rso.amadeus.server;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.soap.client.GetHelloRequest;
import com.example.soap.client.GetHelloResponse;

public class HelloClient extends WebServiceGatewaySupport {

    public GetHelloResponse getHello(String name) {
        GetHelloRequest request = new GetHelloRequest();
        request.setName(name);

        GetHelloResponse response = (GetHelloResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
}
