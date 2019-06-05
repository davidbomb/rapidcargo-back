package net.back.controller;


import net.back.exceptions.InvalidMouvementSortieException;
import net.back.model.Mouvement;
import net.back.service.MouvementService;
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
     * Retriees all mouvements
     * Test purpose only
     * @return a list of mouvements
     */
    @RequestMapping(value = "/api-rest/mouvements", method = RequestMethod.GET)
    public ResponseEntity<List<Mouvement>> getAllMouvements() {
        logger.info("getAllMouvements | retrieves all the mouvements");
        return mouvementService.getAllMouvements();
    }

    /**
     * retrieves the 50 last mouvements saved in the database
     * @return
     */
    @RequestMapping(value = "/api-rest/mouvements/last", method = RequestMethod.GET)
    public ResponseEntity<List<Mouvement>> get50LastMouvements() {
        logger.info("get50LastMouvements | retrieves the 50 last mouvements");
        return mouvementService.get50LastMouvements();

    }

    /**
     * saves a mouvement entree
     * @param mouvement: the mvt about to be saved
     * @return
     */
    @RequestMapping(value = "/api-rest/mouvements/entree", method = RequestMethod.POST)
    public ResponseEntity<Mouvement> saveMouvementEntree(@RequestBody Mouvement mouvement) {
        logger.info("saveMouvementEntree | saves a mouvement entree: " + mouvement);
        return mouvementService.saveMouvementEntree(mouvement);
    }

    /**
     * saves a mouvement sortie
     * @param mouvement: the mvt about to be saved
     * @return
     * @throws InvalidMouvementSortieException
     */
    @RequestMapping(value = "/api-rest/mouvements/sortie", method = RequestMethod.PUT)
    public ResponseEntity<Mouvement> saveMouvementSortie(@RequestBody Mouvement mouvement) throws InvalidMouvementSortieException {
        logger.info("saveMouvementSortie | saves a mouvement sortie: " + mouvement);
        return mouvementService.saveMouvementSortie(mouvement);
    }


}
