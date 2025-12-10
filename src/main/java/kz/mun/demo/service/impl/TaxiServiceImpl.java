package kz.mun.demo.service.impl;

import kz.mun.demo.service.TaxiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static kz.mun.demo.config.TaxiQueueConfig.TRAFFIC_INFO_EXCHANGE;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaxiServiceImpl implements TaxiService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void trafficInfo(String infoText) {
        rabbitTemplate.convertAndSend(TRAFFIC_INFO_EXCHANGE, "", infoText);
    }
}
