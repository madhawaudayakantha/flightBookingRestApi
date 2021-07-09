package com.madhawa.flightapi.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPassengerById() throws MalformedURLException {
        String jsonExpected = "{\"passengerId\":\"567\",\"firstName\":\"madhawa\",\"lastName\":\"gunasekara\",\"bookingId\":\"123456\",\"flights\":[{\"flightNumber\":\"456\",\"departureAirport\":\"DA1\",\"arrivalAirport\":\"AA1\",\"departureDate\":\"2019-12-25\",\"arrivalDate\":\"2019-12-25\"},{\"flightNumber\":\"113\",\"departureAirport\":\"DA2\",\"arrivalAirport\":\"AA2\",\"departureDate\":\"2019-12-28\",\"arrivalDate\":\"2019-12-27\"}]}";

        String base64Creds = getBase64EncodedAutherization();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        URL endpointUrL = new URL("http://localhost:" + port + "/passengers/567");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(endpointUrL.toString(), HttpMethod.GET, request, String.class);
//        Account account = response.getBody();
//        ResponseEntity<String> response = restTemplate.getForEntity(
//                new URL("http://localhost:" + port + "/passengers/567").toString(), String.class);
        System.out.println(jsonExpected);
        assertEquals("200 OK", response.getStatusCode().toString());
        assertEquals(jsonExpected, response.getBody());
    }

    private String getBase64EncodedAutherization() {
        String plainCreds = "admin:admin123";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }
}