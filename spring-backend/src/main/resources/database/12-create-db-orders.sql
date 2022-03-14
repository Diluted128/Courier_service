-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE DB_ORDER (
                               id SERIAL NOT NULL PRIMARY KEY ,
                               date character varying(255),
                               status character varying(255),
                               total_price real NOT NULL,
                               client_id integer,
                               company_id integer,
                               tip real NOT NULL,
                               courier_id integer,
                               reward real,
                               addresee integer
);

