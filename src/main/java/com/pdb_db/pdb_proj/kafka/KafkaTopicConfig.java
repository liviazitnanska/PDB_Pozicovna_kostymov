package com.pdb_db.pdb_proj.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig
{
    @Bean
    public NewTopic pdbTopic()
    {
        return TopicBuilder.name("pdb").build();
    }

}
