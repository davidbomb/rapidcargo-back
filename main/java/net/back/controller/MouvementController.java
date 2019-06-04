package net.back.controller;


import net.back.exceptions.InvalidMouvementSortieException;
import net.back.model.Mouvement;
import net.back.service.MouvementService;
import net.back.vo.MouvementDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MouvementController {

    @Autowired
    private MouvementService mouvementService;



    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @return
     */
    @RequestMapping(value = "/api-rest/mouvements", method = RequestMethod.GET)
    public ResponseEntity<List<Mouvement>> getAllMouvements() {
        logger.info("getAllMouvements | retrieves all the mouvements");
        return mouvementService.getAllMouvements();
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/api-rest/mouvements/last", method = RequestMethod.GET)
    public ResponseEntity<List<Mouvement>> get50LastMouvements() {
        logger.info("get50LastMouvements | retrieves the 50 last mouvements");
        return mouvementService.get50LastMouvements();

    }

    /**
     *
     * @param mouvement
     * @return
     */
    @RequestMapping(value = "/api-rest/mouvements/entree", method = RequestMethod.POST)
    public ResponseEntity<MouvementDTO> saveMouvementEntree(@RequestBody MouvementDTO mouvement) {
        logger.info("saveMouvementEntree | saves a mouvement entree: " + mouvement);
        return mouvementService.saveMouvementEntree(mouvement);
    }

    /**
     *
     * @param mouvement
     * @return
     * @throws InvalidMouvementSortieException
     */
    @RequestMapping(value = "/api-rest/mouvements/sortie", method = RequestMethod.PUT)
    public ResponseEntity<MouvementDTO> saveMouvementSortie(@RequestBody MouvementDTO mouvement) throws InvalidMouvementSortieException {
        logger.info("saveMouvementSortie | saves a mouvement sortie: " + mouvement);
        return mouvementService.saveMouvementSortie(mouvement);
    }


}
