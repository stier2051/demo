package kz.mun.demo.service.impl;

import kz.mun.demo.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

import static kz.mun.demo.config.DocumentsEventQueueConfig.DOCUMENTS_EVENTS_EXCHANGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendAgreementGenerate(UUID agreementId, Locale locale) {
        log.info("Sending agreement generate request, locale = {}", locale.getLanguage());
        rabbitTemplate.convertAndSend(DOCUMENTS_EVENTS_EXCHANGE, "agreement.generate." + locale.getLanguage(), agreementId);
    }

    @Override
    public void sendProtocolGenerate(UUID agreementId, Locale locale) {
        log.info("Sending protocol generate request, locale = {}", locale.getLanguage());
        rabbitTemplate.convertAndSend(DOCUMENTS_EVENTS_EXCHANGE, "protocol.generate." + locale.getLanguage(), agreementId);
    }
}
