-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE application (
                 id SERIAL  NOT NULL PRIMARY KEY ,
                 email character varying(255),
                 phone_number character varying(255),
                 sender_name character varying(255),
                 type integer
);

