package com.example.greet;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class GreetController {


    @GetMapping("greet/taslim")
    @RateLimiter(name="greet",fallbackMethod = "rateLimiterFallback")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello, taslim" +"!!",HttpStatus.OK);
    }

    public ResponseEntity<String> rateLimiterFallback(Exception e){
        return new ResponseEntity<>("greet service does not permit further calls", HttpStatus.TOO_MANY_REQUESTS);
    }
}






