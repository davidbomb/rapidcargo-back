package net.back.service;


import net.back.model.Mouvement;
import net.back.repositories.MouvementRepository;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.activation.FileDataSource;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MouvementRepository mouvementRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * The method send a mail with an attachment
     * @param mouvement
     * @param receiver
     * @return a response entity containing a Boolean (true if it is correctly send, false if not)
     */
    @Override
    public ResponseEntity<Boolean> sendHTMLMails(Mouvement mouvement, String receiver) {
        createMessage(mouvement);
        String[] to = {receiver};
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, CharEncoding.UTF_8);
            logger.debug("sendHTMLMailsFromMailRequest ");
            messageHelper.setFrom("no-reply@cdg.fr");
            messageHelper.setTo(to);
            messageHelper.setText("Un nouveau mouvement a été enregistré depuis le manager de mouvement.");
            messageHelper.setSubject("Mouvement Infos");
            messageHelper.addAttachment("attachment.xml", new FileDataSource("attachment.xml"));
        };

        try {
            logger.info("sendHTMLMailsFromMailRequest | message preparator: " + messagePreparator);
            mailSender.send(messagePreparator);
            logger.info("sendHTMLMailsFromMailRequest | Le Mail a ete envoyé avec succès");
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (MailException e) {
            logger.error("sendHTMLMailsFromMailRequest | Une erreur est survenue lors de l'envoi du mail : " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    /**
     * Creates the attachement describing the mouvement in the XML format
     * @param m: mouvement to describe
     */
    private void createMessage(Mouvement m) {
        logger.info("createMessage | create the message attachement describing the mouvement | " + m.getTypeMouvement());
        String messageID = UUID.randomUUID().toString();
        String currentDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
        try (PrintWriter out = new PrintWriter("attachment.xml")) {
            if(m.getTypeMouvement().equals("ENTREE")) {
                logger.info("preparing attachement | mouvement entree | "+ m.toString());
                out.println(
                    "<CargoMessage type=\"WarehouseMovement-In\">\n" +
                            "<Header from=\"RAPIDCARGO\" to=\"CARGOINFO\" messageTime=\"" + currentDate + " messageId=\""+ messageID + "\"/>\n" +
                            "<WarehouseMovementIn>\n" +
                            "<movementTime>"+ currentDate + " </movementTime>\n" +
                            "<declaredIn code=\""+ m.getCodeLibelle() + "\" label=\"" + m.getLieuDeclaration() + "\"/>\n" +
                            "<from code=\"CDGAF1\" label=\"Air Cargo CDG 1\"/>\n" +
                            "<goods>\n" +
                            "<ref type=\""+ m.getInfosMarchandise().getTypeReference() + "\" code=\""+ m.getInfosMarchandise().getReference() + "\"/>\n" +
                            "<amount quantity=\""+ m.getInfosMarchandise().getQuantite() + "\" weight=\""+ m.getInfosMarchandise().getPoids() + "\"/>\n" +
                            "<description>"+ m.getInfosMarchandise().getDescription() + "< /description>\n" +
                            "<totalRefAmount quantity=\""+ m.getInfosMarchandise().getQuantiteTotaleRef() + "\" weight=\""+ m.getInfosMarchandise().getPoidsTotalRef() + "\"/>\n" +
                            "</goods>\n" +
                            "<customsStatus>" + m.getStatutDouanier() +"</customsStatus>\n" +
                            "</WarehouseMovementIn>\n" +
                            "</CargoMessage>"
                );
            }
            if(m.getTypeMouvement().equals("SORTIE")) {
                logger.info("preparing attachement | mouvement sortie | "+ m.toString());
                out.println(
                "<CargoMessage type=\"WarehouseMovement-Out\">\n" +
                        "<Header from=\"RAPIDCARGO\" to=\"CARGOINFO\" messageTime=\"" + currentDate + " messageId=\""+ messageID + "\"/>\n" +
                        "<WarehouseMovementOut>\n" +
                        "<movementTime>"+ currentDate + " </movementTime>\n" +
                        "<declaredIn code=\""+ m.getCodeLibelle() + "\" label=\"" + m.getLieuDeclaration() + "\"/>\n" +
                        "<to code=\"CDGAF1\" label=\"Air Cargo CDG 1\"/>\n" +
                        "<goods>\n" +
                        "<ref type=\""+ m.getInfosMarchandise().getTypeReference() + "\" code=\""+ m.getInfosMarchandise().getReference() + "\"/>\n" +
                        "<amount quantity=\"" + m.getInfosMarchandise().getQuantite() + "\" weight=\""+ m.getInfosMarchandise().getPoids() + "\"/>\n" +
                        "<description>" + m.getInfosMarchandise().getDescription() + "</description>\n" +
                        "<totalRefAmount quantity=\""+ m.getInfosMarchandise().getQuantiteTotaleRef() + "\" weight=\""+ m.getInfosMarchandise().getPoidsTotalRef() + "\"/>\n" +
                        "</goods>\n" +
                        "<customsStatus>" + m.getStatutDouanier() +"</customsStatus>\n" +
                        "<customsDocument type=\"" + m.getTypeRef() + " ref=\"" + m.getTypeRef()+ "\" />" +
                        "</WarehouseMovementOut>\n" +
                        "</CargoMessage>"
                );
            }

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}