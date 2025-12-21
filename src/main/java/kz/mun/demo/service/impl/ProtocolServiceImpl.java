package kz.mun.demo.service.impl;

import kz.mun.demo.service.ProtocolService;
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
public class ProtocolServiceImpl implements ProtocolService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendProtocolGenerate(UUID protocolId, Locale locale) {
        log.info("Sending protocol generate message for {}, locale: {}", protocolId, locale.getLanguage());
        rabbitTemplate.convertAndSend(DOCUMENTS_EVENTS_EXCHANGE, "protocol.generate." + locale.getLanguage(), protocolId);
    }
}
