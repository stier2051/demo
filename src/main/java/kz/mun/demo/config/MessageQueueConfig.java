package kz.mun.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {
    public static final String SEND_MESSAGE_EXCHANGE = "send-message-x";
    public static final String MESSAGE_EVENTS_ROUTING_KEY = "message-events";

    public static final String SEND_MESSAGE_QUEUE = "send-message-q";
    public static final String SEND_MESSAGE_DELAY_QUEUE = "send-message-wait-q";
    public static final String SEND_MESSAGE_ROUTING_KEY = SEND_MESSAGE_QUEUE;
    public static final String SEND_MESSAGE_DELAY_ROUTING_KEY = SEND_MESSAGE_DELAY_QUEUE;

    public static final String PROCESS_MESSAGE_QUEUE = "process-message-q";

    @Bean
    public DirectExchange sendMessageExchange() {
        return new DirectExchange(SEND_MESSAGE_EXCHANGE);
    }

    @Bean
    Queue sendMessageQueue() {
        return QueueBuilder
                .durable(SEND_MESSAGE_QUEUE)
                .build();
    }

    @Bean
    public Binding sendMessageBinding(Queue sendMessageQueue, DirectExchange sendMessageExchange) {
        return BindingBuilder
                .bind(sendMessageQueue)
                .to(sendMessageExchange)
                .with(SEND_MESSAGE_QUEUE);
    }

    @Bean
    public Queue processMessageQueue() {
        return QueueBuilder
                .durable(PROCESS_MESSAGE_QUEUE)
                .build();
    }

    @Bean
    public Binding processMessageBinding(Queue processMessageQueue, DirectExchange sendMessageExchange) {
        return BindingBuilder
                .bind(processMessageQueue)
                .to(sendMessageExchange)
                .with(MESSAGE_EVENTS_ROUTING_KEY);
    }

    @Bean
    public Queue sendMessageDelayQueue() {
        return QueueBuilder
                .durable(SEND_MESSAGE_DELAY_QUEUE)
                .deadLetterExchange(SEND_MESSAGE_EXCHANGE)
                .deadLetterRoutingKey(SEND_MESSAGE_ROUTING_KEY)
                .ttl(10000)
                .build();
    }

    @Bean
    public Binding sendMessageDelayBinding(Queue sendMessageDelayQueue, DirectExchange sendMessageExchange) {
        return BindingBuilder
                .bind(sendMessageDelayQueue)
                .to(sendMessageExchange)
                .with(SEND_MESSAGE_DELAY_ROUTING_KEY);
    }
}
