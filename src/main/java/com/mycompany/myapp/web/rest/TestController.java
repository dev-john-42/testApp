package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.web.rest.request.ReservationRequest;
import com.mycompany.myapp.web.rest.response.ReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api/SUAPI/jservice/Reservation")
    public ReservationResponse getReservation(@RequestBody ReservationRequest request) {
        String url = "https://airfeedsandbox.staah.net/SUAPI/jservice/Reservation";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic WTJFeEFaS0g6Um92N1NuSXU");
        headers.set("Cookie", "PHPSESSID=2opeacvul6tdd0v6c7oda79qs7");
        headers.set("User-Agent", "PostmanRuntime/7.28.4");
        HttpEntity<ReservationRequest> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(url, entity, ReservationResponse.class);
    }
}
