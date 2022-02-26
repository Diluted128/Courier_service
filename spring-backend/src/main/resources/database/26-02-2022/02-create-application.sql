-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.application (
                 id integer NOT NULL,
                 email character varying(255),
                 phone_number character varying(255),
                 sender_name character varying(255),
                 type integer
);

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);

ALTER TABLE public.application OWNER TO postgres;