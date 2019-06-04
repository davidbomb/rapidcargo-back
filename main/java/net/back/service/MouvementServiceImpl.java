package net.back.service;


import net.back.exceptions.InvalidMouvementSortieException;
import net.back.model.InfosMarchandise;
import net.back.model.Mouvement;
import net.back.model.MouvementEntree;
import net.back.repositories.InfosMarchandiseRepository;
import net.back.repositories.MouvementEntreeRepository;
import net.back.repositories.MouvementRepository;
import net.back.vo.MouvementDTO;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("mouvementService")
public class MouvementServiceImpl implements MouvementService {

    @Autowired
    private MouvementRepository mouvementRepository;

    @Autowired
    private InfosMarchandiseRepository infosMarchandiseRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private DozerBeanMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ResponseEntity<List<Mouvement>> getAllMouvements() {
        List<Mouvement> allMove = mouvementRepository.findAll();
        logger.info("getAllMouvements | All Movements number: "+ allMove.size());
        logger.info("getAllMouvements | 1st movement of the list: "+ allMove.get(0).toString());
        return new ResponseEntity<List<Mouvement>>(allMove, HttpStatus.OK);
    }

    public ResponseEntity<List<Mouvement>> get50LastMouvements() {
        List<Mouvement> mouvements = mouvementRepository.find50LastMouvements(new PageRequest(0, 50));
        logger.info("get50LastMouvements | All Movements number: "+ mouvements.size());
        logger.info("get50LastMouvements | 1st movement of the list: "+ mouvements.get(0).toString());
        return new ResponseEntity<List<Mouvement>>(mouvements, HttpStatus.OK);
    }






    @Override
    public ResponseEntity<MouvementDTO> saveMouvementEntree(MouvementDTO mvt) {
        /**
         * TODO
         * Verification mouvement conforme aux RG
         * throw exceptions if not
         */
        mvt.setDateCreation(LocalDate.now());
        mvt.setUserCreation("default");
        mvt.setCodeLibelle("5136555");
        mvt.setTypeMouvement("ENTREE");
        mvt.setStatutDouanier("CDC");


        Mouvement mvtSaved = mouvementRepository.save(mapper.map(mvt, Mouvement.class));
        mailService.sendHTMLMails(mvtSaved,"david.pignato@atos.net");
        logger.info("saveMouvementEntree | mouvement saved with success");
        return new ResponseEntity<MouvementDTO>(mapper.map(mvtSaved, MouvementDTO.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MouvementDTO> saveMouvementSortie(MouvementDTO mvt) throws InvalidMouvementSortieException {
        if(!isMouvementSortieValid(mapper.map(mvt, Mouvement.class))){
            throw new InvalidMouvementSortieException("Le mouvement d'entrée correspondant n'existe pas");
        }
        Mouvement mvtSaved = mouvementRepository.save(mapper.map(mvt, Mouvement.class));
        mailService.sendHTMLMails(mvtSaved,"david.pignato@atos.net");
        logger.info("saveMouvementSortie | mouvement saved with success");
        return new ResponseEntity<MouvementDTO>(mapper.map(mvtSaved, MouvementDTO.class), HttpStatus.OK);
    }



    /** Fonctions relatives aux regles de gestion **/


    private Boolean isMouvementSortieValid(Mouvement mvt){
        Long idMarchandise = mvt.getInfosMarchandise().getId();
        InfosMarchandise infosMarchandise = infosMarchandiseRepository.findOne(idMarchandise);
        if(infosMarchandise == null) {
            return false;
        } else {
            return true;
        }
    }





}
