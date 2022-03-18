-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE CLIENT (
                               id SERIAL NOT NULL PRIMARY KEY,
                               username character varying(255),
                               first_name character varying(255),
                               last_name character varying(255),
                               password character varying(255),
                               phone_number character varying(255),
                               address_id integer,
                               role_id integer
);

