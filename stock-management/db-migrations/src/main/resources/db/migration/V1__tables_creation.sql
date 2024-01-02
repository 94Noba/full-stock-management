create sequence utilisateurs_id_sequence;
create table utilisateurs(

    id bigint default nextval('utilisateurs_id_sequence') primary key,
    nom_complet varchar not null,
    username varchar(150) not null,
    password varchar(50) not null,
    role varchar(20) not null,
    telephone varchar(50) not null,
    addresse varchar,

    constraint UQ_UTILISATEURS_USERNAME unique(username),
    constraint UQ_UTILISATEURS_TELEPHONE unique(telephone)
);

create sequence clients_id_sequence;
create table clients(

    id bigint default nextval('clients_id_sequence') primary key,
    nom varchar not null,
    telephone varchar(50) not null,
    telephone1 varchar(50),
    addresse varchar,

    constraint UQ_CLIENTS_TELEPHONE unique(telephone)
);

create sequence fournisseurs_id_sequence;
create table fournisseurs(

    id bigint default nextval('fournisseurs_id_sequence') primary key,
    entreprise varchar not null,
    telephone varchar(50) not null,
    telephone1 varchar(50),
    email varchar not null,
    fax varchar,
    addresse varchar,

    constraint UQ_FOURNISSEURS_TELEPHONE unique(telephone),
    constraint UQ_FOURNISSEURS_EMAIL unique(email)
);

create sequence produit_id_sequence;
create table produits(

    id bigint default nextval('produit_id_sequence') primary key,
    designation varchar(150) not null,
    description text,
    prix_unitaire float not null,
    cout_unitaire float,
    prix_achat_unitaire float,
    produit_type varchar not null,

    constraint UQ_PRODUITS_DESIGNATION unique(designation)
);

create sequence stocks_id_sequence;
create table stocks(

    id bigint default nextval('stocks_id_sequence') primary key,
    nom varchar not null,
    telephone varchar(50) not null,
    telephone1 varchar(50),
    addresse varchar not null,

    constraint UQ_STOCKS_NOM unique(nom),
    constraint UQ_STOCKS_TELEPHONE unique(telephone)
);

create sequence mouvement_stock_id_sequence;
create table mouvements_stock(

    id bigint default nextval('mouvement_stock_id_sequence') primary key,
    date_mouvement date not null
);

create sequence ligne_mvt_stock_id_sequence;
create table lignes_mvt_stock(

    id bigint default nextval('ligne_mvt_stock_id_sequence') primary key,
    quantite float not null
);

create sequence type_mvt_stock_id_sequence;
create table types_mvt_stock(

    id bigint default nextval('type_mvt_stock_id_sequence') primary key,
    libelle varchar(50) not null,

    constraint UQ_TYPES_MVT_STOCK_LIBELLE unique(libelle)
);

create sequence roles_id_sequence;
create table roles(

    id bigint default nextval('roles_id_sequence') primary key,
    libelle varchar(50) not null,

    constraint UQ_ROLES_LIBELLE unique(libelle)
);

create sequence permissions_id_Sequence;
create table permissions(

    id bigint default nextval('permissions_id_Sequence') primary key ,
    access varchar(50) not null,

    constraint UQ_PERMISSIONS_ACCESS unique(access)
);

create sequence cmd_client_id_sequence;
create table commandes_client(

    id bigint default nextval('cmd_client_id_sequence') primary key,
    date_commande date not null
);

create sequence ligne_commande_client_id_sequence;
create table lignes_commande_client(

    id bigint default nextval('ligne_commande_client_id_sequence') primary key,
    quantite float not null,
    livre boolean not null default false
);

create sequence retour_cmd_client_id_sequence;
create table retours_cmd_client(

    id bigint default nextval('retour_cmd_client_id_sequence') primary key,
    date_retour date not null,
    valeur_cmd_avant_retour float not null
);

create sequence ligne_retour_cmd_client_id_sequence;
create table lignes_retour_cmd_client(

    id bigint default nextval('ligne_retour_cmd_client_id_sequence') primary key,
    quantite_retourne float not null
);

create sequence cmd_fournisseur_id_sequence;
create table commandes_fournisseur(

    id bigint default nextval('cmd_fournisseur_id_sequence') primary key,
    date_commande date not null
);

create sequence ligne_commande_fournisseur_id_sequence;
create table lignes_commande_fournisseur(

    id bigint default nextval('ligne_commande_fournisseur_id_sequence') primary key,
    quantite float not null,
    livre boolean not null default false
);

create sequence retour_cmd_fournisseur_id_sequence;
create table retours_cmd_fournisseur(

    id bigint default nextval('retour_cmd_fournisseur_id_sequence') primary key,
    date_retour date not null,
    valeur_cmd_avant_retour float not null
);

create sequence ligne_retour_cmd_fournisseur_id_sequence;
create table lignes_retour_cmd_fournisseur(

    id bigint default nextval('ligne_retour_cmd_fournisseur_id_sequence') primary key ,
    quantite_retourne float not null
);