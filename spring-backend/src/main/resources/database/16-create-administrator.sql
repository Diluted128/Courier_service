-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE ADMINISTRATOR (
                      id SERIAL NOT NULL PRIMARY KEY ,
                      username character varying(255) NOT NULL,
                      password character varying(255) NOT NULL,
                      role_id integer
);