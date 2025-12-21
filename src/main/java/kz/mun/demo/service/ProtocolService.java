package kz.mun.demo.service;

import java.util.Locale;
import java.util.UUID;

public interface ProtocolService {
    void sendProtocolGenerate(UUID protocolId, Locale locale);
}
