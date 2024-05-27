package br.com.augustocml.controller;

import br.com.augustocml.record.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    private static final String MSG = "Hello world with Open Telemetry";
    @GetMapping("/message")
    public Message helloWorld(){
        logger.info("Hello world message called! ");
        return new Message(MSG);
    }
}
