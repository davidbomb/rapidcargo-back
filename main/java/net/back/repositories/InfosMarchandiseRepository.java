package net.back.repositories;

import net.back.model.InfosMarchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfosMarchandiseRepository extends JpaRepository<InfosMarchandise, Long> {

    @Query("select infosMarchandise from InfosMarchandise infosMarchandise"
            + " where infosMarchandise.reference = :reference"
            + " and infosMarchandise.typeReference = :typeReference")

    public InfosMarchandise findByReference(@Param("reference") String reference, @Param("typeReference") String typeReference);
}
