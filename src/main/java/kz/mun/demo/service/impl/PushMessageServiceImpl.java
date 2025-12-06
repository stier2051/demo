package kz.mun.demo.service.impl;

import kz.mun.demo.model.Contact;
import kz.mun.demo.model.Message;
import kz.mun.demo.model.MessageType;
import kz.mun.demo.model.PushType;
import kz.mun.demo.service.PushMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static kz.mun.demo.config.MessageQueueConfig.MESSAGE_EVENTS_ROUTING_KEY;
import static kz.mun.demo.config.MessageQueueConfig.SEND_MESSAGE_EXCHANGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class PushMessageServiceImpl implements PushMessageService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void send(Contact contact, PushType pushType) {
        log.info(contact.toString());
        Message pushMessage = Message.builder()
                .id(UUID.randomUUID())
                .messageType(MessageType.SMS)
                .messageBody("test body")
                .contact(contact)
                .build();
        rabbitTemplate.convertAndSend(SEND_MESSAGE_EXCHANGE, MESSAGE_EVENTS_ROUTING_KEY, pushMessage);
    }
}
