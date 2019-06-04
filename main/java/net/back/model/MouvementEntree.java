package net.back.model;

import net.back.model.InfosMarchandise;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class MouvementEntree extends Mouvement {



    //@Column(name="code_libelle");
    private String codeLibelle;

    //@Column(name = "statut_douanier");
    private String statutDouanier;

    private InfosMarchandise infosMarchandise;







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

    public InfosMarchandise getInfosMarchandise() {
        return infosMarchandise;
    }
    public void setInfosMarchandise(InfosMarchandise infosMarchandise) {
        this.infosMarchandise = infosMarchandise;
    }
//
//    @Override
//    public String toString() {
//        return "MouvementEntree{" +
//                "codeLibelle='" + codeLibelle + '\'' +
//                ", statutDouanier='" + statutDouanier + '\'' +
//                ", infosMarchandise=" + infosMarchandise.toString() +
//                '}';
//    }
}
