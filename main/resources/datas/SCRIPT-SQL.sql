

CREATE TABLE mouvement (
    id_mouvement SERIAL UNIQUE,
    date_creation date,
    user_creation varchar(255),
    date_mouvement date,
    lieu_declaration varchar(255),
    infos_marchandise_id int,
    code_libelle varchar(255),
    statut_douanier varchar(255),
    type_ref varchar(255),
    type_mouvement varchar(255)
);

CREATE TABLE infos_marchandise (
  id_infos_marchandise SERIAL UNIQUE,
  type_reference varchar(255),
  reference varchar(255),
  quantite int,
  quantite_totale_reference int,
  poids int,
  poids_total_reference int,
  description varchar(255)
);

ALTER TABLE mouvement
ADD CONSTRAINT infos_marchandise_id
FOREIGN KEY (infos_marchandise_id) REFERENCES infos_marchandise(id_infos_marchandise);

ALTER TABLE mouvement
ADD COLUMN magasin_origine varchar(255);

ALTER TABLE mouvement
ADD COLUMN magasin_destination varchar(255);