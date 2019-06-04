package net.back.repositories;

import net.back.model.Mouvement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MouvementRepository extends JpaRepository<Mouvement, Long> {

    @Query("select mouvement from Mouvement mouvement")
    public List<Mouvement> find50LastMouvements(Pageable pageable);


}
