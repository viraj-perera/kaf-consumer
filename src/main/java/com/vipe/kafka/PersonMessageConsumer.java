package com.vipe.kafka;

import com.vipe.kafka.config.PersonMessageConsumerConfig;
import com.vipe.kafka.config.StringMessageConsumerConfig;
import com.vipe.kafka.type.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PersonMessageConsumer {

    @KafkaListener(topics = PersonMessageConsumerConfig.topic2 , groupId = "person")
    public void listenWithHeaders2(@Payload Person person, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println( "Received Message: " + person.toString() + " from partition: " + partition);
    }

}
