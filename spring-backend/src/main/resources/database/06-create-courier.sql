-- liquibase formatted sql
-- changeset wj:1 runOnChange:true
CREATE TABLE courier (
                                id SERIAL  NOT NULL PRIMARY KEY ,
                                PIN character varying(255),
                                email character varying(255),
                                first_name character varying(255),
                                last_name character varying(255),
                                phone_number character varying(255),
                                district_id integer,
                                password character varying(255),
                                distance integer,
                                location character varying(255),
                                cash real
);

