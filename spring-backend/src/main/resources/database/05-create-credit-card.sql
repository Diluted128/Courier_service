-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE credit_card (
                    id SERIAL  NOT NULL PRIMARY KEY ,
                    cvv character varying(255),
                    card_number character varying(255),
                    expired character varying(255)
);



