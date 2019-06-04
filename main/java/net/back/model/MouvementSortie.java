package net.back.model;

import net.back.model.InfosMarchandise;
import javax.persistence.Entity;

@Entity
public class MouvementSortie extends Mouvement {

    private String codeLibelle;

    private String statutDouanier;

    private String typeRef;

//    private InfosMarchandise infosMarchandise;

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

//    public InfosMarchandise getInfosMarchandise() {
//        return infosMarchandise;
//    }
//
//    public void setInfosMarchandise(InfosMarchandise infosMarchandise) {
//        this.infosMarchandise = infosMarchandise;
//    }
//
//    @Override
//    public String toString() {
//        return "MouvementSortie{" +
//                "codeLibelle='" + codeLibelle + '\'' +
//                ", statutDouanier='" + statutDouanier + '\'' +
//                ", typeRef='" + typeRef + '\'' +
//                ", infosMarchandise=" + infosMarchandise.toString() +
//                '}';
//    }
}
