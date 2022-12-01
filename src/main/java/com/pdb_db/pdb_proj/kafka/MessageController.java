package com.pdb_db.pdb_proj.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController
{

    private KafkaTemplate<String,String > kafkaTemplate;


    @PostMapping
    public void publish(@RequestBody MessageRequest request)
    {
            kafkaTemplate.send("pdb",request.message());
    }

}
