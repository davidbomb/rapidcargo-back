package net.back.vo;

import net.back.model.InfosMarchandise;

import javax.persistence.*;
import java.time.LocalDate;

public class MouvementDTO {


    private Long id;

    private LocalDate dateCreation;

    private String userCreation;

    private LocalDate dateMouvement;

    private String lieuDeclaration = "RapidCargo CDG";

    private InfosMarchandise infosMarchandise;

    private String codeLibelle;

    private String statutDouanier;

    private String typeRef;

    private String typeMouvement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public LocalDate getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(LocalDate dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public String getLieuDeclaration() {
        return lieuDeclaration;
    }

    public void setLieuDeclaration(String lieuDeclaration) {
        this.lieuDeclaration = lieuDeclaration;
    }

    public InfosMarchandise getInfosMarchandise() {
        return infosMarchandise;
    }

    public void setInfosMarchandise(InfosMarchandise infosMarchandise) {
        this.infosMarchandise = infosMarchandise;
    }

    public String getCodeLibelle() {
        return codeLibelle;
    }

    public void setCodeLibelle(String codeLibelle) {
        this.codeLibelle = codeLibelle;
    }

    public String getStatutDouanier() {
        return statutDouanier;
    }

    public void setStatutDouanier(String statutDouanier) {
        this.statutDouanier = statutDouanier;
    }

    public String getTypeRef() {
        return typeRef;
    }

    public void setTypeRef(String typeRef) {
        this.typeRef = typeRef;
    }

    public String getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    @Override
    public String toString() {
        return "MouvementDTO{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", userCreation='" + userCreation + '\'' +
                ", dateMouvement=" + dateMouvement +
                ", lieuDeclaration='" + lieuDeclaration + '\'' +
                ", infosMarchandise=" + infosMarchandise +
                ", codeLibelle='" + codeLibelle + '\'' +
                ", statutDouanier='" + statutDouanier + '\'' +
                ", typeRef='" + typeRef + '\'' +
                ", type='" + typeMouvement + '\'' +
                '}';
    }
}
