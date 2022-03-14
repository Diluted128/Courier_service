-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE COMPANY (
                    id SERIAL  NOT NULL PRIMARY KEY ,
                    name character varying(255),
                    type character varying(255)
);


