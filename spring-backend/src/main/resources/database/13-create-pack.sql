-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE PACK (
                             id SERIAL NOT NULL PRIMARY KEY ,
                             courier_id integer,
                             order_id integer,
                             pack_locker_id integer
);

