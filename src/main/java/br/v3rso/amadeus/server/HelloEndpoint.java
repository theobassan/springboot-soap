package br.v3rso.amadeus.server;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soap.service.GetHelloRequest;
import com.example.soap.service.GetHelloResponse;

@Endpoint
public class HelloEndpoint {
	private static final String NAMESPACE_URI = "http://example.com/soap-web-service";

	public HelloEndpoint() {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHelloRequest")
	@ResponsePayload
	public GetHelloResponse getCountry(@RequestPayload GetHelloRequest request) {
		GetHelloResponse response = new GetHelloResponse();
		response.setGreeting("hello " + request.getName());

		return response;
	}
}
