package kz.mun.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxiQueueConfig {

    public static final String TRAFFIC_INFO_EXCHANGE = "traffic-info-x";
    public static final String TAXI_A_QUEUE = "taxi-a-q";
    public static final String TAXI_B_QUEUE = "taxi-b-q";

    @Bean
    public FanoutExchange trafficInfoExchange() {
        return new FanoutExchange(TRAFFIC_INFO_EXCHANGE);
    }

    @Bean
    public Queue taxiAQueue() {
        return QueueBuilder
                .durable(TAXI_A_QUEUE)
                .build();
    }

    @Bean
    public Queue taxiBQueue() {
        return QueueBuilder
                .durable(TAXI_B_QUEUE)
                .build();
    }

    @Bean
    public Binding taxiAQueueBinding(FanoutExchange trafficInfoExchange, Queue taxiAQueue) {
        return BindingBuilder
                .bind(taxiAQueue)
                .to(trafficInfoExchange);
    }

    @Bean
    public Binding taxiBQueueBinding(FanoutExchange trafficInfoExchange, Queue taxiBQueue) {
        return BindingBuilder
                .bind(taxiBQueue)
                .to(trafficInfoExchange);
    }
}
