package net.back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.back.model.InfosMarchandise;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "mouvement")
public class Mouvement {

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mouvement")
    private Long id;

    @Column(name="date_creation")
    private LocalDate dateCreation;

    @Column(name="user_creation")
    private String userCreation;

    @Column(name="date_mouvement")
    private LocalDate dateMouvement;

    private String lieuDeclaration = "RapidCargo CDG";

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name="infos_marchandise_id")
    private InfosMarchandise infosMarchandise;

    @Column(name="code_libelle")
    private String codeLibelle;

    @Column(name="statut_douanier")
    private String statutDouanier;

    @Column(name="type_ref")
    private String typeRef;

    @Column(name="type_mouvement")
    private String typeMouvement;

    @Column(name="magasin_origine")
    private String magasinOrigine;

    @Column(name="magasin_destination")
    private String magasinDestination;


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

    public String getMagasinOrigine() {
        return magasinOrigine;
    }

    public void setMagasinOrigine(String magasinOrigine) {
        this.magasinOrigine = magasinOrigine;
    }

    public String getMagasinDestination() {
        return magasinDestination;
    }

    public void setMagasinDestination(String magasinDestination) {
        this.magasinDestination = magasinDestination;
    }

    @Override
    public String toString() {
        return "Mouvement{" +
                "id=" + id +
                ", dateCreation=" + dateCreation +
                ", userCreation='" + userCreation + '\'' +
                ", dateMouvement=" + dateMouvement +
                ", lieuDeclaration='" + lieuDeclaration + '\'' +
                ", infosMarchandise=" + infosMarchandise +
                ", codeLibelle='" + codeLibelle + '\'' +
                ", statutDouanier='" + statutDouanier + '\'' +
                ", typeRef='" + typeRef + '\'' +
                ", typeMouvement='" + typeMouvement + '\'' +
                '}';
    }
}
