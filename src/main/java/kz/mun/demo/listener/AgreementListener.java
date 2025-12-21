package kz.mun.demo.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static kz.mun.demo.config.AgreementQueueConfig.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementListener {

    @RabbitListener(queues = AGREEMENT_GENERATE_KZ_QUEUE)
    public void sendAgreementGenerateKzQueue(UUID agreementId) {
        log.info("Agreement generate kz: {}", agreementId);
    }

    @RabbitListener(queues = AGREEMENT_GENERATE_EN_QUEUE)
    public void sendAgreementGenerateEnQueue(UUID agreementId) {
        log.info("Agreement generate en: {}", agreementId);
    }

    @RabbitListener(queues = AGREEMENT_GENERATE_DE_QUEUE)
    public void sendAgreementGenerateDeQueue(UUID agreementId) {
        log.info("Agreement generate de: {}", agreementId);
    }

    @RabbitListener(queues = AGREEMENT_GENERATE_ALL_LOCALES_QUEUE)
    public void sendAgreementGenerateAllLocalesQueue(UUID agreementId) {
        log.info("Agreement generate all locales: {}", agreementId);
    }
}
