-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE office_worker (
                                      id SERIAL  NOT NULL PRIMARY KEY ,
                                      PIN character varying(255),
                                      cash integer,
                                      username character varying(255),
                                      first_name character varying(255),
                                      last_name character varying(255),
                                      phone_number character varying(255),
                                      address_id integer,
                                      password character varying(255),
                                      role_id integer
);

