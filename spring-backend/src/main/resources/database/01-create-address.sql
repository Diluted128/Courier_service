--liquibase formatted sql
--changeset wj:1 runOnChange:true

CREATE TABLE ADDRESS (
                    id SERIAL NOT NULL PRIMARY KEY ,
                    flat_number character varying(255),
                    local_number character varying(255),
                    location character varying(255),
                    postal_code character varying(255),
                    street character varying(255),
                    town character varying(255),
                    district_id integer
);