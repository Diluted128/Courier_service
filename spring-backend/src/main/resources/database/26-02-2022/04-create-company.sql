-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.company (
                    id integer NOT NULL,
                    name character varying(255),
                    type character varying(255)
);

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);

ALTER TABLE public.company OWNER TO postgres;