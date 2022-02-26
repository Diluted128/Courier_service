-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.district (
                                 id integer NOT NULL,
                                 name character varying(255)
);

ALTER TABLE ONLY public.district
    ADD CONSTRAINT district_pkey PRIMARY KEY (id);

ALTER TABLE public.district OWNER TO postgres;