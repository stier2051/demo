package kz.mun.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentsEventQueueConfig {
    public static final String DOCUMENTS_EVENTS_EXCHANGE = "agreement-events-x";

    /**
     * <domain>.<action>.<region>.<channel>
     * example:
     * domain - [loan, banner, payment]
     * action - [created, updated, deleted]
     * region - [kz, en, de]
     * channel - [web, mobile]
     * <p>
     * another way
     * <system>.<entity>.<eventType>
     * online-credit.loan-request.created
     */

    public static final String AGREEMENT_GENERATE_KZ_QUEUE = "agreement-generate-kz-queue";
    public static final String AGREEMENT_GENERATE_EN_QUEUE = "agreement-generate-en-queue";
    public static final String AGREEMENT_GENERATE_DE_QUEUE = "agreement-generate-de-queue";

    public static final String AGREEMENT_GENERATE_ALL_LOCALES_QUEUE = "agreement-generate-all-locales-queue";

    public static final String AGREEMENT_EDIT_KZ_QUEUE = "agreement-edit-kz-queue";
    public static final String AGREEMENT_EDIT_EN_QUEUE = "agreement-edit-en-queue";
    public static final String AGREEMENT_EDIT_DE_QUEUE = "agreement-edit-de-queue";

    public static final String PROTOCOL_GENERATE_KZ_QUEUE = "protocol-generate-kz-queue";
    public static final String PROTOCOL_GENERATE_EN_QUEUE = "protocol-generate-en-queue";
    public static final String PROTOCOL_GENERATE_DE_QUEUE = "protocol-generate-de-queue";

    public static final String ALL_GENERATE_EVENTS_QUEUE = "all-generate-events-queue";

    @Bean
    public TopicExchange agreementExchange() {
        return new TopicExchange(DOCUMENTS_EVENTS_EXCHANGE);
    }

    @Bean
    public Queue agreementGenerateKzQueue() {
        return QueueBuilder
                .durable(AGREEMENT_GENERATE_KZ_QUEUE)
                .build();
    }

    @Bean
    public Queue agreementGenerateEnQueue() {
        return QueueBuilder
                .durable(AGREEMENT_GENERATE_EN_QUEUE)
                .build();
    }

    @Bean
    public Queue agreementGenerateDeQueue() {
        return QueueBuilder
                .durable(AGREEMENT_GENERATE_DE_QUEUE)
                .build();
    }

    @Bean
    public Queue agreementGenerateAllLocalesQueue() {
        return QueueBuilder
                .durable(AGREEMENT_GENERATE_ALL_LOCALES_QUEUE)
                .build();
    }

    @Bean
    public Queue protocolGenerateKzQueue() {
        return QueueBuilder
                .durable(PROTOCOL_GENERATE_KZ_QUEUE)
                .build();
    }

    @Bean
    public Queue protocolGenerateEnQueue() {
        return QueueBuilder
                .durable(PROTOCOL_GENERATE_EN_QUEUE)
                .build();
    }

    @Bean
    public Queue protocolGenerateDeQueue() {
        return QueueBuilder
                .durable(PROTOCOL_GENERATE_DE_QUEUE)
                .build();
    }

    @Bean
    public Queue allGenerateEventsQueue() {
        return QueueBuilder
                .durable(ALL_GENERATE_EVENTS_QUEUE)
                .build();
    }

    @Bean
    public Binding agreementGenerateKzBinding(Queue agreementGenerateKzQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(agreementGenerateKzQueue)
                .to(documentsEventExchange)
                .with("agreement.generate.kz.#");
    }

    @Bean
    public Binding agreementGenerateEnBinding(Queue agreementGenerateEnQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(agreementGenerateEnQueue)
                .to(documentsEventExchange)
                .with("agreement.generate.en.#");
    }

    @Bean
    public Binding agreementGenerateDeBinding(Queue agreementGenerateDeQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(agreementGenerateDeQueue)
                .to(documentsEventExchange)
                .with("agreement.generate.de.#");
    }

    @Bean
    public Binding agreementGenerateAllLocalesBinding(Queue agreementGenerateAllLocalesQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(agreementGenerateAllLocalesQueue)
                .to(documentsEventExchange)
                .with("agreement.generate.#");
    }

    @Bean
    public Binding protocolGenerateKzBinding(Queue protocolGenerateKzQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(protocolGenerateKzQueue)
                .to(documentsEventExchange)
                .with("protocol.generate.kz.#");
    }

    @Bean
    public Binding protocolGenerateEnBinding(Queue protocolGenerateEnQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(protocolGenerateEnQueue)
                .to(documentsEventExchange)
                .with("protocol.generate.en.#");
    }

    @Bean
    public Binding protocolGenerateDeBinding(Queue protocolGenerateDeQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(protocolGenerateDeQueue)
                .to(documentsEventExchange)
                .with("protocol.generate.de.#");
    }

    @Bean
    public Binding allGenerateEventsBinding(Queue allGenerateEventsQueue, TopicExchange documentsEventExchange) {
        return BindingBuilder
                .bind(allGenerateEventsQueue)
                .to(documentsEventExchange)
                .with("#.generate.#");
    }
}
