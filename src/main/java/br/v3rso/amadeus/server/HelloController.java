package br.v3rso.amadeus.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.soap.client.GetHelloResponse;

@RestController
public class HelloController {
	@Autowired
    private final HelloClient client;

    HelloController(HelloClient client) {
        this.client = client;
    }

    @GetMapping("/hello/{name}")
    String one(@PathVariable String name) {
        GetHelloResponse response = client.getHello(name);

        return response.getGreeting();
    }
}
