-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE ROLE (
                  id SERIAL NOT NULL PRIMARY KEY ,
                  name character varying(255) NOT NULL
);