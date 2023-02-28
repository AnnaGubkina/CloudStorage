CREATE SCHEMA netology_diploma;

create table netology_diploma.users
(
    id       bigserial    not null,
    username varchar(255) not null
        constraint users_login_key
            unique,
    password varchar(255) not null,
    CONSTRAINT pk_users PRIMARY KEY (id)

);

create table netology_diploma.files
(
    id        bigserial,
    filename varchar(255),
    date      date,
    type      varchar(255),
    file_data oid,
    size      bigint,
    user_id   bigint not null
        constraint user_id
            references netology_diploma.users,
    CONSTRAINT pk_files PRIMARY KEY (id)
);

create table netology_diploma.roles
(

    id   serial
        constraint pk_roles
            primary key,
    name varchar(255)

);

create table netology_diploma.user_roles
(
    user_id bigint not null
        constraint user_id_fk
            references netology_diploma.users ,
    role_id bigint not null
        constraint role_id_fk
            references netology_diploma.roles ,
    constraint user_role
        primary key (user_id, role_id)
);