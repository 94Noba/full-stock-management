create sequence utilisateurs_id_sequence;
create table utilisateurs(

    id bigint default nextval('utilisateurs_id_sequence') primary key,
    nom_complet varchar not null,
    username varchar(150) not null,
    password varchar(50) not null,
    telephone varchar(50) not null,
    addresse varchar,

    constraint UQ_UTILISATEURS_USERNAME unique(username)
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

create sequence roles_id_sequence;
create table roles(

    id bigint default nextval('roles_id_sequence'),
    libelle varchar(50) not null,

    constraint UQ_ROLES_LIBELLE unique(libelle)
);

create sequence permissions_id_Sequence;
create table permissions(

    id bigint default nextval('permissions_id_Sequence'),
    access varchar(50) not null,

    constraint UQ_PERMISSIONS_ACCESS unique(access)
);

