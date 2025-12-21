package kz.mun.demo.listener;

import kz.mun.demo.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static kz.mun.demo.config.MessageQueueConfig.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageListener {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = SEND_MESSAGE_QUEUE)
    public void sendMessage(Message pushMessage) {
        try {
            log.info("Sending message: {}", pushMessage);
            throw new Exception("Sending message failed");
        } catch (Exception e) {
            log.error("Sending message failed", e);
            rabbitTemplate.convertAndSend(SEND_MESSAGE_EXCHANGE, SEND_MESSAGE_DELAY_ROUTING_KEY, pushMessage);
        }
    }
}
