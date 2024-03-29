package net.back.service;

import net.back.exceptions.InvalidMouvementSortieException;
import net.back.model.Mouvement;
import net.back.model.MouvementEntree;
import net.back.vo.MouvementDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MouvementService {

    public ResponseEntity<List<Mouvement>> getAllMouvements();

    public ResponseEntity<List<Mouvement>> get50LastMouvements();

    public ResponseEntity<Mouvement> saveMouvementEntree(Mouvement mouvement);

    public ResponseEntity<Mouvement> saveMouvementSortie(Mouvement mouvement) throws InvalidMouvementSortieException;
}
