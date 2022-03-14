-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE ADMINISTRATOR (
                      id integer NOT NULL PRIMARY KEY ,
                      login character varying(255) NOT NULL,
                      password character varying(255) NOT NULL,
                      role_id integer
);