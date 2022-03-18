-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE CREDIT_CARD (
                    id SERIAL  NOT NULL PRIMARY KEY ,
                    cvv  character varying(255),
                    card_number character varying(255),
                    expired_date character varying(255),
                    client_id integer NOT NULL
);



