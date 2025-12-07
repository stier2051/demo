package kz.mun.demo.service.impl;

import kz.mun.demo.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static kz.mun.demo.config.AgreementQueueConfig.AGREEMENT_EVENTS_EXCHANGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendAgreementGenerate(UUID agreementId) {
        rabbitTemplate.convertAndSend(AGREEMENT_EVENTS_EXCHANGE, "agreement.generate", agreementId);
    }
}
