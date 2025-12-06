package kz.mun.demo.service.impl;

import kz.mun.demo.model.Contact;
import kz.mun.demo.model.PushType;
import kz.mun.demo.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {
    @Override
    public void send(Contact contact, PushType pushType) {
        log.info(contact.toString());
    }
}
