package net.javalearning.springbootkafkatutorial.kafka;

import net.javalearning.springbootkafkatutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = "testJSONTopic", groupId = "myGroup")
    public void Consume(User user) {
        LOGGER.info(String.format("JSON Message received : %s", user.toString()));
    }
}
