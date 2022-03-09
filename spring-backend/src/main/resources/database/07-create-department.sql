-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE department (
                                   id SERIAL  NOT NULL PRIMARY KEY ,
                                   address_id integer,
                                   company_id integer
);

