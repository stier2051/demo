package kz.mun.demo.controller;

import kz.mun.demo.model.Contact;
import kz.mun.demo.service.PushMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kz.mun.demo.model.PushType.CONGRATS;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class SendMessageController {

    private final PushMessageService pushMessageService;

    @PostMapping("/push/message/congrats")
    public void pushMessageCongrats(@RequestBody Contact contact) {
        pushMessageService.send(contact, CONGRATS);
    }
}
