package kz.mun.demo.service;

import java.util.Locale;
import java.util.UUID;

public interface AgreementService {
    void sendAgreementGenerate(UUID agreementId, Locale locale);
    void sendProtocolGenerate(UUID agreementId, Locale locale);
}
