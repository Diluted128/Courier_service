-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.department (
                                   id integer NOT NULL,
                                   address_id integer,
                                   company_id integer
);

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);

ALTER TABLE public.department OWNER TO postgres;