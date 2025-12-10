package kz.mun.demo.controller;

import kz.mun.demo.service.TaxiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxi")
@RequiredArgsConstructor
public class TaxiController {

    private final TaxiService taxiService;

    @PostMapping("/traffic-info")
    public void trafficInfo(@RequestBody String infoText) {
        taxiService.trafficInfo(infoText);
    }
}
