-- liquibase formatted sql
-- changeset wj:1
CREATE TABLE public.pack_locker (
                                    id integer NOT NULL,
                                    address_id integer
);

ALTER TABLE ONLY public.pack_locker
    ADD CONSTRAINT pack_locker_pkey PRIMARY KEY (id);

ALTER TABLE public.pack_locker OWNER TO postgres;