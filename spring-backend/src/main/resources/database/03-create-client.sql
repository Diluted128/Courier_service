-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE client (
                               id SERIAL NOT NULL PRIMARY KEY,
                               email character varying(255),
                               first_name character varying(255),
                               last_name character varying(255),
                               password character varying(255),
                               phone_number character varying(255),
                               address_id integer,
                               credit_card_id integer
);

