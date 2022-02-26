-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.pack (
                             id integer NOT NULL,
                             courier_id integer,
                             order_id integer,
                             pack_locker_id integer
);

ALTER TABLE ONLY public.pack
    ADD CONSTRAINT pack_pkey PRIMARY KEY (id);

ALTER TABLE public.pack OWNER TO postgres;