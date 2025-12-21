package kz.mun.demo.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static kz.mun.demo.config.DocumentsEventQueueConfig.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProtocolListener {

    @RabbitListener(queues = PROTOCOL_GENERATE_KZ_QUEUE)
    public void receiveProtocolGenerateKZ(UUID agreementId) {
        log.info("Receive protocol generate kz: {}", agreementId);
    }

    @RabbitListener(queues = PROTOCOL_GENERATE_EN_QUEUE)
    public void receiveProtocolGenerateEN(UUID agreementId) {
        log.info("Receive protocol generate en: {}", agreementId);
    }

    @RabbitListener(queues = PROTOCOL_GENERATE_DE_QUEUE)
    public void receiveProtocolGenerateDE(UUID agreementId) {
        log.info("Receive protocol generate de: {}", agreementId);
    }

    @RabbitListener(queues = ALL_GENERATE_EVENTS_QUEUE)
    public void receiveAllGenerateEventsQueue(UUID agreementId) {
        log.info("Receive all generate events queue: {}", agreementId);
    }
}
