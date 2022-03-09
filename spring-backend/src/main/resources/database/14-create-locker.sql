-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE pack_locker (
                                    id SERIAL  NOT NULL PRIMARY KEY ,
                                    address_id integer
);


