package kz.mun.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private UUID id;
    private MessageType messageType;
    private String messageBody;
    private Contact contact;
}
