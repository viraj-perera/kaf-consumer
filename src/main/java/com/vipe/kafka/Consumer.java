package com.vipe.kafka;

import com.vipe.kafka.config.KafkaConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = KafkaConsumerConfig.topic1 , groupId = "foo")
    public void listenWithHeaders( @Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println( "Received Message: " + message + " from partition: " + partition);
    }
}
