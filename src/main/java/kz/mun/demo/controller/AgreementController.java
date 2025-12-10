package kz.mun.demo.controller;

import kz.mun.demo.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @PostMapping("/{agreementId}/generate")
    public void generateAgreement(@PathVariable UUID agreementId) {
        agreementService.sendAgreementGenerate(agreementId);
    }
}
