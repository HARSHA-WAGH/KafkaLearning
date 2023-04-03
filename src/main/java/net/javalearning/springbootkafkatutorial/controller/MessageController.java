package net.javalearning.springbootkafkatutorial.controller;

import net.javalearning.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer KafkaProducer;

    public MessageController(net.javalearning.springbootkafkatutorial.kafka.KafkaProducer kafkaProducer) {
        KafkaProducer = kafkaProducer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        KafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
