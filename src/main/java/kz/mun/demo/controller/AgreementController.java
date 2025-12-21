package kz.mun.demo.controller;

import kz.mun.demo.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping("/{agreementId}/generate")
    public void generateAgreement(@PathVariable UUID agreementId,
                                  @RequestParam (required = false) String locale) {
        agreementService.sendAgreementGenerate(agreementId, Locale.forLanguageTag(locale));
    }
}
