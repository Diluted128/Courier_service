-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE item (
                             id SERIAL  NOT NULL PRIMARY KEY ,
                             description character varying(255),
                             name character varying(255),
                             price real NOT NULL,
                             size character varying(255),
                             company_id integer
);