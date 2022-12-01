package com.pdb_db.pdb_proj.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {


    @KafkaListener(topics = "pdb",groupId = "groupID")

    void listener(String data)
    {
        System.out.println("Listener recieved: " + data);
    }


}
