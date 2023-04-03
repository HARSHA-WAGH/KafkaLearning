package net.javalearning.springbootkafkatutorial.controller;

import net.javalearning.springbootkafkatutorial.kafka.JSONKafkaProducer;
import net.javalearning.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JSONMessageController {

    private JSONKafkaProducer jsonKafkaProducer;

    public JSONMessageController(JSONKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam User user)
    {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON message sent to Kafka topic");
    }
}
