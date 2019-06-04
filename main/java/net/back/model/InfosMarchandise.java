package net.back.model;


import javax.persistence.*;

@Entity
@Table(name = "infos_marchandise")
public class InfosMarchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_infos_marchandise")
    private Long id;

    @Column(name="type_reference")
    private String typeReference;

    @Column(name="reference")
    private String reference;

    @Column(name="quantite")
    private Integer quantite;

    @Column(name="poids")
    private Integer poids;

    @Column(name="quantite_totale_reference")
    private Integer quantiteTotaleRef;

    @Column(name="poids_total_reference")
    private Integer poidsTotalRef;

    @Column(name="description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(String typeReference) {
        this.typeReference = typeReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getQuantiteTotaleRef() {
        return quantiteTotaleRef;
    }

    public void setQuantiteTotaleRef(Integer quantiteTotaleRef) {
        this.quantiteTotaleRef = quantiteTotaleRef;
    }

    public Integer getPoidsTotalRef() {
        return poidsTotalRef;
    }

    public void setPoidsTotalRef(Integer poidsTotalRef) {
        this.poidsTotalRef = poidsTotalRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
