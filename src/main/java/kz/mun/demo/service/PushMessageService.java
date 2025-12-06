package kz.mun.demo.service;

import kz.mun.demo.model.Contact;
import kz.mun.demo.model.PushType;

public interface PushMessageService {
    void send(Contact contact, PushType pushType);
}
