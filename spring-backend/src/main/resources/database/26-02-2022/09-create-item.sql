-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.item (
                             id integer NOT NULL,
                             description character varying(255),
                             name character varying(255),
                             price real NOT NULL,
                             size character varying(255),
                             company_id integer
);

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);

ALTER TABLE public.item OWNER TO postgres;