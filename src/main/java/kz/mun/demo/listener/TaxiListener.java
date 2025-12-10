package kz.mun.demo.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static kz.mun.demo.config.TaxiQueueConfig.TAXI_A_QUEUE;
import static kz.mun.demo.config.TaxiQueueConfig.TAXI_B_QUEUE;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaxiListener {

    @RabbitListener(queues = TAXI_A_QUEUE)
    public void processTaxiAQueue(String infoText) {
        log.info("processTaxiAQueue: " + infoText);
    }

    @RabbitListener(queues = TAXI_B_QUEUE)
    public void processTaxiBQueue(String infoText) {
        log.info("processTaxiBQueue: " + infoText);
    }
}
