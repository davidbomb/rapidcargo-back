package net.back.controller;


import net.back.model.Mouvement;
import net.back.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class MailController {



    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/mail/send", method = RequestMethod.GET)
    public ResponseEntity<Boolean> sendMails(Mouvement mouvement, String receiver) {
        return mailService.sendHTMLMails(mouvement, "test");
    }
}
