-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE PACK_LOCKER (
                                    id SERIAL  NOT NULL PRIMARY KEY ,
                                    address_id integer
);


