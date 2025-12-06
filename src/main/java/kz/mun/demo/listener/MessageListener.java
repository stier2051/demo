package kz.mun.demo.listener;

import kz.mun.demo.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static kz.mun.demo.config.MessageQueueConfig.SEND_MESSAGE_QUEUE;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageListener {

    @RabbitListener(queues = SEND_MESSAGE_QUEUE)
    public void sendMessage(Message pushMessage) {
        log.info("Sending message: {}", pushMessage);
    }
}
