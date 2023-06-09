package net.javalearning.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name("testTopic")
                .build();
    }

    @Bean
    public NewTopic testJSONTopic(){
        return TopicBuilder.name("testJSONTopic")
                .build();
    }
}
