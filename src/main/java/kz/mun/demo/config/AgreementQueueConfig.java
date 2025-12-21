package kz.mun.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgreementQueueConfig {
    public static final String AGREEMENT_EVENTS_EXCHANGE = "agreement-events-x";

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

    @Bean
    public TopicExchange agreementExchange() {
        return new TopicExchange(AGREEMENT_EVENTS_EXCHANGE);
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
    public Binding agreementGenerateKzBinding(Queue agreementGenerateKzQueue, TopicExchange agreementExchange) {
        return BindingBuilder
                .bind(agreementGenerateKzQueue)
                .to(agreementExchange)
                .with("agreement.generate.kz.#");
    }

    @Bean
    public Binding agreementGenerateEnBinding(Queue agreementGenerateEnQueue, TopicExchange agreementExchange) {
        return BindingBuilder
                .bind(agreementGenerateEnQueue)
                .to(agreementExchange)
                .with("agreement.generate.en.#");
    }

    @Bean
    public Binding agreementGenerateDeBinding(Queue agreementGenerateDeQueue, TopicExchange agreementExchange) {
        return BindingBuilder
                .bind(agreementGenerateDeQueue)
                .to(agreementExchange)
                .with("agreement.generate.de.#");
    }

    @Bean
    public Binding agreementGenerateAllLocalesBinding(Queue agreementGenerateAllLocalesQueue, TopicExchange agreementExchange) {
        return BindingBuilder
                .bind(agreementGenerateAllLocalesQueue)
                .to(agreementExchange)
                .with("agreement.generate.#");
    }
}
