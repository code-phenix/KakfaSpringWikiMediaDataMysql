package com.wikimedia2database.consumer;

import com.wikimedia2database.consumer.entity.WikimediaData;
import com.wikimedia2database.consumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer
{
    private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);


    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId ="myGroup1")
    public void consume(String eventMessage){
        LOGGER.info("Message Event Recieved =>"+eventMessage);

        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);
    }

}
