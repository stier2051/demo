package kz.mun.demo.controller;

import kz.mun.demo.service.ProtocolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/protocols")
@RequiredArgsConstructor
public class ProtocolController {

    private final ProtocolService protocolService;

    @PostMapping("/{protocolId}/generate")
    public void sendProtocolGenerate(@PathVariable UUID protocolId,
                                     @RequestParam(required = false) String locale) {
        protocolService.sendProtocolGenerate(protocolId, Locale.forLanguageTag(locale));
    }
}
