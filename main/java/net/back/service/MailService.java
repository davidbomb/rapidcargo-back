package net.back.service;


import net.back.model.Mouvement;
import net.back.vo.MailRequest;

import java.io.ByteArrayOutputStream;

import org.springframework.http.ResponseEntity;

public interface MailService {
    public ResponseEntity<Boolean> sendHTMLMails(Mouvement mouvement, String receiver);
    
    public ResponseEntity<Boolean> sendHTMLMailsFromMailRequestWithAttachment(MailRequest mailRequest, String fileName, ByteArrayOutputStream data);
}
