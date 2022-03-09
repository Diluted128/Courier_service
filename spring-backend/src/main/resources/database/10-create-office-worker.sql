-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE office_worker (
                                      id SERIAL  NOT NULL PRIMARY KEY ,
                                      pin character varying(255),
                                      cash integer,
                                      email character varying(255),
                                      first_name character varying(255),
                                      last_name character varying(255),
                                      phone_number character varying(255),
                                      address_id integer,
                                      password character varying(255),
                                      office_worker_type character varying(255)
);

